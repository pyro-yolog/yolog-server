package com.pyro.yolog.domain.diary.dto.response;

import com.pyro.yolog.domain.diary.entity.Mood;
import com.pyro.yolog.domain.diary.entity.Weather;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class PreviewDiaryResponse {
    private Long id;
    private String dayName;
    private String content;
    private Mood mood;
    private Weather weather;
    private LocalDate travelDate;
}
