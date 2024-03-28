package com.pyro.yolog.domain.memo.api;

import com.pyro.yolog.domain.memo.dto.request.MemoRequest;
import com.pyro.yolog.domain.memo.dto.response.MemoDetailResponse;
import com.pyro.yolog.domain.memo.dto.response.MemoPreviewResponse;
import com.pyro.yolog.domain.memo.service.MemoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("trip-diaries/{tripId}/memos")
public class MemoController implements MemoApi {
    private final MemoService memoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    @Override
    public void saveMemo(@PathVariable final Long tripId,
                         @RequestBody @Valid final MemoRequest request) {
        memoService.saveMemo(tripId, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{memoId}")
    @Override
    public MemoDetailResponse getMemo(@PathVariable final Long tripId, @PathVariable final Long memoId) {
        return memoService.getMemo(memoId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<MemoPreviewResponse> getMemos(@PathVariable final Long tripId) {
        return memoService.getMemosByTrip(tripId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{memoId}")
    public void deleteMemo(@PathVariable final Long tripId, @PathVariable final Long memoId) {
        memoService.deleteMemo(memoId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{memoId}")
    public void updateMemo(@PathVariable final Long tripId, @PathVariable final Long memoId,
                           @RequestBody @Valid final MemoRequest request) {
        memoService.updateMemo(memoId, request);
    }
}
