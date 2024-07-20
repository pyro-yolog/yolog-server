package com.pyro.yolog.domain.trip.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.pyro.yolog.domain.trip.exception.RequestColorCoverInvalidException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum SpineColor {
    LAVENDAR_PURPLE("#A38AAE"),
    PEARL_AQUA("#8BC1BE"),
    SKY_BLUE("#7C98AC"),
    SAGE_GRAY("#8E8E8C"),
    PEACH("#D3A685"),
    ROSY_BROWN("#BD7E7E"),
    LIGHT_CORAL("#CA96A6"),
    TAUPE("#907C6A"),
    SAND("#B1A285"),
    MOSS_GREEN("#93A47E"),
    SAGE_GREEN("#77977E"),
    CHARCOAL_GRAY("#535354")
    ;

    private final String code;

    @JsonCreator
    public static SpineColor parsing(String inputValue) {
        return Stream.of(SpineColor.values())
                .filter(color -> color.getCode().equals(inputValue))
                .findFirst()
                .orElseThrow(RequestColorCoverInvalidException::new);
    }
}
