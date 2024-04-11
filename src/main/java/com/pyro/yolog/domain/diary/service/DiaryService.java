package com.pyro.yolog.domain.diary.service;

import com.pyro.yolog.domain.diary.dto.DiaryResponse;
import com.pyro.yolog.domain.diary.mapper.DiaryMapper;
import com.pyro.yolog.domain.diary.repository.DiaryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final DiaryMapper diaryMapper;

    public DiaryResponse getDiary(Long tripId, LocalDateTime date) {
        return diaryMapper.toResponse(diaryRepository.findByTripAndTravelDate(tripId, date)
                .orElseThrow(EntityNotFoundException::new));
    }
}
