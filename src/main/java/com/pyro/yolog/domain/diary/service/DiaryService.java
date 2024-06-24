package com.pyro.yolog.domain.diary.service;

import com.pyro.yolog.domain.diary.dto.request.DiaryContentRequest;
import com.pyro.yolog.domain.diary.dto.request.MoodRequest;
import com.pyro.yolog.domain.diary.dto.request.WeatherRequest;
import com.pyro.yolog.domain.diary.dto.response.DefaultDiaryResponse;
import com.pyro.yolog.domain.diary.dto.response.DiaryResponse;
import com.pyro.yolog.domain.diary.entity.Diary;
import com.pyro.yolog.domain.diary.entity.Mood;
import com.pyro.yolog.domain.diary.entity.Weather;
import com.pyro.yolog.domain.diary.mapper.DiaryMapper;
import com.pyro.yolog.domain.diary.repository.DiaryRepository;
import com.pyro.yolog.domain.trip.entity.Trip;
import com.pyro.yolog.domain.trip.repository.TripRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiaryService {
    private static final String DAY = "Day";
    private final DiaryRepository diaryRepository;
    private final TripRepository tripRepository;
    private final DiaryMapper diaryMapper;

    public DiaryResponse getDiary(Long tripId, LocalDateTime date) {
        return diaryMapper.toResponse(diaryRepository.findByTripIdAndTravelDate(tripId, date)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public DefaultDiaryResponse createDefaultDiary(final Long tripId, final LocalDateTime date) {
        final LocalDateTime startDate = tripRepository.findById(tripId)
                .orElseThrow(EntityNotFoundException::new).getStartDate();
        final String title = DAY + ChronoUnit.DAYS.between(startDate, date);
        return diaryMapper.toDefaultFormatResponse(
                diaryRepository.save(diaryMapper.toEntity(title, startDate)));
    }

    @Transactional
    public void updateDiaryContent(Long id, DiaryContentRequest request) {
        final Diary diary = diaryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        diary.updateContent(request);
    }

    @Transactional
    public void deleteDiary(Long id) {
        diaryRepository.deleteById(id);
    }

    @Transactional
    public void updateWeather(Long id, WeatherRequest request) {
        diaryRepository.findById(id).orElseThrow(EntityNotFoundException::new)
                .updateWeather(Weather.valueOf(request.getWeather()));
    }

    @Transactional
    public void updateMood(Long id, MoodRequest request) {
        diaryRepository.findById(id).orElseThrow(EntityNotFoundException::new)
                .updateMood(Mood.valueOf(request.getMood()));
    }


    @Transactional
    public void deleteOutOfDuration(Trip trip) {
        diaryRepository.findById(trip.getId()).ifPresent(diary -> {
            if (diary.getTravelDate().isBefore(trip.getStartDate()) || diary.getTravelDate().isAfter(trip.getFinishDate())) {
                diaryRepository.deleteById(diary.getId());
            }
        });
    }
}
