package com.pyro.yolog.domain.trip.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class TripResponse {
    private Long id;
    private String name;
    private String destination;
    private String coverImageUrl;

    private LocalDateTime startDate;
    private LocalDateTime finishDate;
}
