package com.pyro.yolog.domain.diary.service;

import com.pyro.yolog.domain.auth.service.AuthService;
import com.pyro.yolog.domain.diary.dto.request.DiaryContentRequest;
import com.pyro.yolog.domain.diary.dto.request.DiaryDateRequest;
import com.pyro.yolog.domain.diary.dto.request.MoodRequest;
import com.pyro.yolog.domain.diary.dto.request.WeatherRequest;
import com.pyro.yolog.domain.diary.dto.response.DefaultDiaryResponse;
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

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiaryService {
    private static final String DAY = "Day";

    private final AuthService authService;
    private final DiaryRepository diaryRepository;
    private final TripRepository tripRepository;
    private final DiaryMapper diaryMapper;

    public DetailDiaryResponse getDiary(Long id) {
        Diary diary = diaryRepository.findById(id).orElseThrow(DiaryNotFoundException::new);
        checkDiaryOwner(diary);
        return new DetailDiaryResponse(diary);
    }


    public List<PreviewDiaryResponse> getDiaries(Long tripId, String dayName) {
        checkTripOwner(tripRepository.findById(tripId)
                .orElseThrow(TripNotFoundException::new));
        List<Diary> diaries = diaryRepository.findAllByTripIdAndDayName(tripId, dayName);
        return diaries.stream().map(PreviewDiaryResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public DefaultDiaryResponse createDefaultDiary(final Long tripId, final DiaryDateRequest request) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(TripNotFoundException::new);
        final String dayName = DAY + (ChronoUnit.DAYS.between(trip.getStartDate(), request.getDate()) + 1);
        return diaryMapper.toDefaultFormatResponse(
                diaryRepository.save(diaryMapper.toEntity(trip, dayName, request.getDate())));
    }

    @Transactional
    public void updateDiaryTitleAndContent(Long id, DiaryContentRequest request) {
        final Diary diary = diaryRepository.findById(id).orElseThrow(DiaryNotFoundException::new);
        checkDiaryOwner(diary);
        diary.updateTitleAndContent(request);
    }

    @Transactional
    public void deleteDiary(Long id) {
        checkDiaryOwner(diaryRepository.findById(id).orElseThrow(DiaryNotFoundException::new));
        diaryRepository.deleteById(id);
    }

    @Transactional
    public void updateWeather(Long id, WeatherRequest request) {
        Diary diary = diaryRepository.findById(id).orElseThrow(DiaryNotFoundException::new);
        checkDiaryOwner(diary);
        diary.updateWeather(request.getWeather());
    }

    @Transactional
    public void updateMood(Long id, MoodRequest request) {
        Diary diary = diaryRepository.findById(id).orElseThrow(DiaryNotFoundException::new);
        checkTripOwner(diary.getTrip());
        diary.updateMood(request.getMood());
    }


    @Transactional
    public void deleteOutOfDuration(Trip trip) {
        checkTripOwner(trip);
        diaryRepository.findById(trip.getId()).ifPresent(diary -> {
            if (diary.getTravelDate().isBefore(trip.getStartDate()) || diary.getTravelDate().isAfter(trip.getFinishDate())) {
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
