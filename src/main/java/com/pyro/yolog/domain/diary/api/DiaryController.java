package com.pyro.yolog.domain.diary.api;

import com.pyro.yolog.domain.diary.dto.DiaryResponse;
import com.pyro.yolog.domain.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("trip-diaries/{tripId}")
public class DiaryController implements DiaryApi {
    private final DiaryService diaryService;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/{date}")
    @Override
    public DiaryResponse getDiary(@PathVariable final Long tripId, @PathVariable final LocalDateTime date) {
        return diaryService.getDiary(tripId, date);
    }
}
