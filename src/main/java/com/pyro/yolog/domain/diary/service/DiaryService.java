package com.pyro.yolog.domain.diary.service;

import com.pyro.yolog.domain.diary.dto.request.DiaryContentRequest;
import com.pyro.yolog.domain.diary.dto.response.DefaultDiaryResponse;
import com.pyro.yolog.domain.diary.dto.response.DiaryResponse;
import com.pyro.yolog.domain.diary.entity.Diary;
import com.pyro.yolog.domain.diary.mapper.DiaryMapper;
import com.pyro.yolog.domain.diary.repository.DiaryRepository;
import com.pyro.yolog.domain.trip.service.TripService;
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
    private final TripService tripService;
    private final DiaryRepository diaryRepository;
    private final DiaryMapper diaryMapper;

    public DiaryResponse getDiary(Long tripId, LocalDateTime date) {
        return diaryMapper.toResponse(diaryRepository.findByTripAndTravelDate(tripId, date)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public DefaultDiaryResponse createDefaultDiary(final Long tripId, final LocalDateTime date) {
        final LocalDateTime startDate = tripService.getTrip(tripId).getStartDate();
        final String title = DAY + ChronoUnit.DAYS.between(startDate, date);
        return diaryMapper.toDefaultFormatResponse(diaryRepository.save(diaryMapper.toEntity(title, startDate)));
    }

    @Transactional
    public void updateDiaryContent(Long id, DiaryContentRequest request) {
        final Diary diary = diaryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        diary.updateContent(request);
    }
}
