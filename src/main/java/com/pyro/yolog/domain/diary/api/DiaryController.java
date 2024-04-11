package com.pyro.yolog.domain.diary.api;

import com.pyro.yolog.domain.diary.dto.response.DefaultDiaryResponse;
import com.pyro.yolog.domain.diary.dto.response.DiaryResponse;
import com.pyro.yolog.domain.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("trip-diaries")
public class DiaryController implements DiaryApi {
    private final DiaryService diaryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{tripId}/{date}")
    @Override
    public DiaryResponse getDiary(@PathVariable final Long tripId, @PathVariable final LocalDateTime date) {
        return diaryService.getDiary(tripId, date);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{tripId}")
    @Override
    public DefaultDiaryResponse createDefaultDiary(@PathVariable final Long tripId, @PathVariable final LocalDateTime date) {
        return diaryService.createDefaultDiary(tripId, date);
    }

}
