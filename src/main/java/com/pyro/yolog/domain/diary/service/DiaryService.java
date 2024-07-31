package com.pyro.yolog.domain.diary.service;

import com.pyro.yolog.domain.auth.service.AuthService;
import com.pyro.yolog.domain.diary.dto.request.*;
import com.pyro.yolog.domain.diary.dto.response.DetailDiaryResponse;
import com.pyro.yolog.domain.diary.dto.response.PreviewDiaryResponse;
import com.pyro.yolog.domain.diary.entity.Diary;
import com.pyro.yolog.domain.diary.exception.DiaryNotFoundException;
import com.pyro.yolog.domain.diary.mapper.DiaryMapper;
import com.pyro.yolog.domain.diary.repository.DiaryRepository;
import com.pyro.yolog.domain.member.exception.OwnerNotEqualException;
import com.pyro.yolog.domain.trip.entity.Trip;
import com.pyro.yolog.domain.trip.exception.TripNotFoundException;
import com.pyro.yolog.domain.trip.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiaryService {
    private final AuthService authService;
    private final DiaryRepository diaryRepository;
    private final TripRepository tripRepository;
    private final DiaryMapper diaryMapper;

    public DetailDiaryResponse getDiary(Long id) {
        final Diary diary = getDiaryById(id);
        return new DetailDiaryResponse(diary);
    }

    private Diary getDiaryById(Long id) {
        final Diary diary = diaryRepository.findById(id)
                .orElseThrow(DiaryNotFoundException::new);
        checkDiaryOwner(diary);
        return diary;
    }

    public List<PreviewDiaryResponse> getDiaries(Long tripId, LocalDate dayName) {
        checkTripOwner(tripRepository.findById(tripId)
                .orElseThrow(TripNotFoundException::new));
        List<Diary> diaries = diaryRepository.findAllByTripIdAndTravelDate(tripId, dayName);
        return diaries.stream().map(PreviewDiaryResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void createDiary(final Long tripId, final CreateDiaryRequest request) {
        final Trip trip = tripRepository.findById(tripId)
                .orElseThrow(TripNotFoundException::new);
        diaryRepository.save(diaryMapper.toEntity(request, trip));
    }

    @Transactional
    public void deleteDiary(Long id) {
        checkDiaryOwner(diaryRepository.findById(id)
                .orElseThrow(DiaryNotFoundException::new));
        diaryRepository.deleteById(id);
    }

    @Transactional
    public void updateDiary(Long id, UpdateDiaryRequest request) {
        Diary diary = getDiaryById(id);
        updateDiaryDetails(diary, request);
    }

    private void updateDiaryDetails(Diary diary, UpdateDiaryRequest request) {
        updateFieldIfPresent(request.getTitle(), diary::updateTitle);
        updateFieldIfPresent(request.getContent(), diary::updateContent);
        updateFieldIfPresent(request.getMood(), diary::updateMood);
        updateFieldIfPresent(request.getWeather(), diary::updateWeather);
    }

    private <T> void updateFieldIfPresent(T value, Consumer<T> updateMethod) {
        if (value != null) {
            updateMethod.accept(value);
        }
    }


    @Transactional
    public void deleteOutOfDuration(Trip trip) {
        checkTripOwner(trip);
        diaryRepository.findById(trip.getId()).ifPresent(diary -> {
            if (diary.getTravelDate().isBefore(trip.getStartDate())
                    || diary.getTravelDate().isAfter(trip.getFinishDate())) {
                diaryRepository.deleteById(diary.getId());
            }
        });
    }

    private void checkDiaryOwner(Diary diary) {
        checkTripOwner(diary.getTrip());
    }

    private void checkTripOwner(Trip trip) {
        if (!trip.getMember().equals(authService.getLoginUser())) {
            throw new OwnerNotEqualException();
        }
    }
}
