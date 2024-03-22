package com.pyro.yolog.domain.memo.api;

import com.pyro.yolog.domain.memo.dto.request.MemoRequest;
import com.pyro.yolog.domain.memo.service.MemoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("trip-diaries/{tripId}/memos")
public class MemoController {
    private final MemoService memoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void saveMemo(@PathVariable final Long tripId,
                         @RequestBody @Valid final MemoRequest request) {
        memoService.saveMemo(tripId, request);
    }
}
