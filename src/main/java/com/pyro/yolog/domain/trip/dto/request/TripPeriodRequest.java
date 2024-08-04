package com.pyro.yolog.domain.trip.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripPeriodRequest {
    @Schema(defaultValue = "2024-07-05")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Schema(defaultValue = "2024-07-10")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDate;
}
