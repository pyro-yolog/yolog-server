package com.pyro.yolog.domain.trip.controller;

import com.pyro.yolog.domain.trip.dto.TripRequest;
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
    public void saveTrip(@RequestBody @Valid final TripRequest request) {
        tripService.saveTrip(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateTrip(@PathVariable Long id, @RequestBody @Valid final TripRequest request) {
        tripService.updateTrip(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
    }
}
