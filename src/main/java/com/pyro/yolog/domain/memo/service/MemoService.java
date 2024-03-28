package com.pyro.yolog.domain.memo.service;

import com.pyro.yolog.domain.memo.dto.MultimediaDto;
import com.pyro.yolog.domain.memo.dto.request.MemoRequest;
import com.pyro.yolog.domain.memo.dto.response.MemoDetailResponse;
import com.pyro.yolog.domain.memo.dto.response.MemoPreviewResponse;
import com.pyro.yolog.domain.memo.entity.Memo;
import com.pyro.yolog.domain.memo.mapper.MemoMapper;
import com.pyro.yolog.domain.memo.repository.MemoRepository;
import com.pyro.yolog.domain.trip.service.TripService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    private final MemoMapper memoMapper;
    private final TripService tripService;
    private final MultimediaService multimediaService;

    @Transactional
    public void saveMemo(final Long tripId, final MemoRequest request) {
        if (isNoContent(request)) {
            return;
        }
        final Memo memo = memoRepository.save(
                memoMapper.toEntity(tripService.getTrip(tripId), request));
        multimediaService.saveMultimedias(memo, request.getMultimediaDtos());
    }

    private boolean isNoContent(MemoRequest request) {
        return request.getTitle().isBlank() && request.getMultimediaDtos().isEmpty();
    }

    public MemoDetailResponse getMemo(Long memoId) {
        List<MultimediaDto> multimediaDtos = multimediaService.getMultimedias(memoId);
        return memoMapper.toDetailResponse(memoRepository.findById(memoId)
                .orElseThrow(EntityNotFoundException::new), multimediaDtos);

    }

    public void deleteMemo(Long memoId) {
        memoRepository.deleteById(memoId);
    }

    @Transactional
    public void updateMemo(Long memoId, @Valid MemoRequest request) {
        if (isNoContent(request)) {
            return;
        }
        final Memo memo = memoRepository.findById(memoId).orElseThrow(EntityNotFoundException::new);
        memo.update(request);
        multimediaService.deleteMultimedias(memo);
        multimediaService.saveMultimedias(memo, request.getMultimediaDtos());
    }

}
