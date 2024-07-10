package com.pyro.yolog.domain.trip.dto;

import com.pyro.yolog.domain.trip.entity.ColorCover;
import com.pyro.yolog.domain.trip.entity.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class TripResponse {
    private Long id;
    private String name;
    private String destination;
    private String coverImageUrl;
    private String colorCover;

    private LocalDate startDate;
    private LocalDate finishDate;

    public TripResponse(Trip trip) {
        this.id = trip.getId();
        this.name = trip.getName();
        this.destination = trip.getDestination();
        this.coverImageUrl = trip.getCoverImageUrl();
        this.colorCover = getColorCode(trip.getColorCover());
        this.startDate = trip.getStartDate();
        this.finishDate = trip.getFinishDate();
    }

    private String getColorCode(ColorCover colorCover) {
        if (colorCover == null) {
            return null;
        }
        return colorCover.getCode();
    }
}
