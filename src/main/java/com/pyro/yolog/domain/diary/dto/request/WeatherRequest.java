package com.pyro.yolog.domain.diary.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class WeatherRequest {
    private String weather;
}
