package com.pyro.yolog.domain.diary.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Weather {
    SUNNY("맑음"),
    CLOUDY("흐림"),
    RAIN("비"),
    SNOW("눈"),
    WINDS("바람");

    private final String name;
}
