package com.pyro.yolog.domain.diary.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Mood {
    HAPPY("행복한"),
    NORMAL("평범한"),
    TIRED("피곤한"),
    UPSET("속상한"),
    ANGRY("화나는");

    private final String name;
}