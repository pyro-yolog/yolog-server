package com.pyro.yolog.domain.trip.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.pyro.yolog.domain.trip.exception.RequestColorCoverInvalidException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum ColorCover {
    PALE_YELLOW("#FFFFB5"),
    AQUA_BLUE("#D2F5F5"),
    PASTEL_BLUE("#C6DCE9"),
    GRAY_GREEN("#9DAAA2"),
    PALE_MINT("#C6EFDC"),
    PALE_PEACH("#FED5CF"),
    BABY_PINK("#FFD1DB"),
    BEIGE_BROWN("#BBA498"),
    IVORY("#F2E3C7"),
    PALE_OLIVE_GREEN("#C4D4B1"),
    PALE_GREEN("#B2BDA8"),
    LIGHT_BROWN("#A49D92"),
    PALE_AQUA("#C6DBDA"),
    PALE_CORAL("#F1B598"),
    LAVENDER("#D3C7E6"),
    PALE_LILAC("#ECD5E3")
    ;

    private final String code;

    @JsonCreator
    public static ColorCover parsing(String inputValue) {
        return Stream.of(ColorCover.values())
                .filter(color -> color.getCode().equals(inputValue))
                .findFirst()
                .orElseThrow(RequestColorCoverInvalidException::new);
    }
}
