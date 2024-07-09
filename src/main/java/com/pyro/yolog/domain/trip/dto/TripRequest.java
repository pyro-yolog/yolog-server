package com.pyro.yolog.domain.trip.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripRequest {
    private String name;
    private String destination;

    @URL
    private String coverImageUrl;

    @Schema(defaultValue = "2024-07-05")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Schema(defaultValue = "2024-07-10")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDate;
}
