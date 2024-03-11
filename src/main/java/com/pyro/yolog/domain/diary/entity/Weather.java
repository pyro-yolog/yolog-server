package com.pyro.yolog.domain.diary.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Weather {
    SUNNY,
    PARTLY_CLOUDY,
    CLOUDY,
    RAIN,
    SNOW,
    WINDS,
    THUNDER_LIGHTENING

}
