package com.pyro.yolog.domain.memo.service;

import com.pyro.yolog.domain.memo.dto.request.MemoRequest;
import com.pyro.yolog.domain.memo.entity.Memo;
import com.pyro.yolog.domain.memo.mapper.MemoMapper;
import com.pyro.yolog.domain.memo.mapper.MultimediaMapper;
import com.pyro.yolog.domain.memo.repository.MemoRepository;
import com.pyro.yolog.domain.memo.repository.MultimediaRepository;
import com.pyro.yolog.domain.trip.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    private final MultimediaRepository multimediaRepository;
    private final MemoMapper memoMapper;
    private final MultimediaMapper multimediaMapper;
    private final TripService tripService;

    @Transactional
    public void saveMemo(final Long tripId, final MemoRequest request) {
        if (request.getTitle().isBlank()
                && request.getMultimediaRequest().getContentUrl().isBlank()) {
            return;
        }
        final Memo memo = memoRepository.save(
                memoMapper.toEntity(tripService.getTrip(tripId), request));
        multimediaRepository.save(multimediaMapper.toEntity(memo, request.getMultimediaRequest()));
    }
    
}
