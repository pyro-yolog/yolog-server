package com.pyro.yolog.domain.diary.dto;

import com.pyro.yolog.domain.diary.entity.Mood;
import com.pyro.yolog.domain.diary.entity.Weather;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class DiaryResponse {
    private Long id;
    private String title;
    private String content;
    private Mood mood;
    private Weather weather;
    private LocalDateTime travelDate;
}
