package com.pyro.yolog.domain.diary.api;

import com.pyro.yolog.domain.diary.dto.request.DiaryContentRequest;
import com.pyro.yolog.domain.diary.dto.request.DiaryDateRequest;
import com.pyro.yolog.domain.diary.dto.request.MoodRequest;
import com.pyro.yolog.domain.diary.dto.response.DefaultDiaryResponse;
import com.pyro.yolog.domain.diary.dto.response.DetailDiaryResponse;
import com.pyro.yolog.domain.diary.dto.response.PreviewDiaryResponse;
import com.pyro.yolog.domain.diary.dto.request.WeatherRequest;
import com.pyro.yolog.domain.diary.service.DiaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("diaries")
public class DiaryController implements DiaryApi {
    private final DiaryService diaryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    @Override
    public DetailDiaryResponse getDiary(@PathVariable final Long id) {
        return diaryService.getDiary(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{tripId}/days/{date}")
    @Override
    public List<PreviewDiaryResponse> getDiaries(@PathVariable final Long tripId, @PathVariable final LocalDate date) {
        return diaryService.getDiaries(tripId, date);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{tripId}")
    @Override
    public DefaultDiaryResponse createDefaultDiary(@PathVariable final Long tripId, @RequestBody DiaryDateRequest request) {
        return diaryService.createDefaultDiary(tripId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/content")
    @Override
    public void updateDiaryTitleAndContent(@PathVariable final Long id, @RequestBody final DiaryContentRequest request) {
        diaryService.updateDiaryTitleAndContent(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Override
    public void deleteDiary(@PathVariable final Long id) {
        diaryService.deleteDiary(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/weather")
    @Override
    public void updateWeather(@PathVariable final Long id, @Valid @RequestBody final WeatherRequest request) {
        diaryService.updateWeather(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/mood")
    @Override
    public void updateMood(@PathVariable final Long id, @Valid  @RequestBody final MoodRequest request) {
        diaryService.updateMood(id, request);
    }
}
