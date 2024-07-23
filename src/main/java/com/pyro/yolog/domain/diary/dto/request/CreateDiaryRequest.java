package com.pyro.yolog.domain.diary.dto.request;

import com.pyro.yolog.domain.diary.entity.Mood;
import com.pyro.yolog.domain.diary.entity.Weather;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDiaryRequest {
    private String title;
    private String content;
    private LocalDate travelDate;

    @Schema(defaultValue = "행복한")
    private Mood mood;
    @Schema(defaultValue = "맑음")
    private Weather weather;
}
