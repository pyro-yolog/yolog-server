package com.pyro.yolog.domain.trip.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class TripResponse {
    private Long id;
    private String name;
    private String destination;
    private String coverImageUrl;

    private LocalDate startDate;
    private LocalDate finishDate;
}
