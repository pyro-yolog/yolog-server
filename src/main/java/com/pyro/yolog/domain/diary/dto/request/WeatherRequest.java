package com.pyro.yolog.domain.diary.dto.request;

import com.pyro.yolog.domain.diary.entity.Weather;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class WeatherRequest {
    private Weather weather;
}
