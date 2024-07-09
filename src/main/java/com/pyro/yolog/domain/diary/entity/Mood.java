package com.pyro.yolog.domain.diary.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.pyro.yolog.domain.diary.exception.RequestMoodNameInvalidException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Mood {
    HAPPY("행복한"),
    NORMAL("평범한"),
    TIRED("피곤한"),
    UPSET("속상한"),
    ANGRY("화나는");

    private final String name;

    @JsonCreator
    public static Mood parsing(String inputValue) {
        return Stream.of(Mood.values())
                .filter(mood -> mood.getName().equals(inputValue))
                .findFirst()
                .orElseThrow(RequestMoodNameInvalidException::new);
    }
}