package com.pyro.yolog.domain.trip.controller;

import com.pyro.yolog.domain.trip.dto.SaveTripRequest;
import com.pyro.yolog.domain.trip.service.TripService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("trip-diaries")
public class TripController {
    private final TripService tripService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void saveTrip(@RequestBody @Valid final SaveTripRequest request) {
        tripService.saveTrip(request);
    }

}
