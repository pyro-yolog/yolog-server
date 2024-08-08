package com.pyro.yolog.domain.trip.dto.response;

import com.pyro.yolog.domain.trip.entity.CoverColor;
import com.pyro.yolog.domain.trip.entity.SpineColor;
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
    private String coverColor;
    private String spineColor;

    private LocalDate startDate;
    private LocalDate finishDate;

    public TripResponse(Trip trip) {
        this.id = trip.getId();
        this.name = trip.getName();
        this.destination = trip.getDestination();
        this.coverImageUrl = trip.getCoverImageUrl();
        this.coverColor = getCoverColorCode(trip.getCoverColor());
        this.spineColor = getSpineColorCode(trip.getSpineColor());
        this.startDate = trip.getStartDate();
        this.finishDate = trip.getFinishDate();
    }

    private String getCoverColorCode(CoverColor coverColor) {
        if (coverColor == null) {
            return null;
        }
        return coverColor.getCode();
    }

    private String getSpineColorCode(SpineColor spineColor) {
        if (spineColor == null) {
            return null;
        }
        return spineColor.getCode();
    }
}
