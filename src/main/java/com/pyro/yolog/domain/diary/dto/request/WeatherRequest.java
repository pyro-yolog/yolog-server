package com.pyro.yolog.domain.diary.dto.request;

import com.pyro.yolog.domain.diary.entity.Weather;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherRequest {
    private Weather weather;
}
