package com.pyro.yolog.domain.diary.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.pyro.yolog.domain.diary.exception.RequestWeatherNameInvalidException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Weather {
    SUNNY("맑음"),
    CLOUDY("흐림"),
    RAIN("비"),
    SNOW("눈"),
    WINDS("바람");

    private final String name;

    @JsonCreator
    public static Weather parsing(String inputValue) {
        return Stream.of(Weather.values())
                .filter(weather -> weather.getName().equals(inputValue))
                .findFirst()
                .orElseThrow(RequestWeatherNameInvalidException::new);
    }
}
