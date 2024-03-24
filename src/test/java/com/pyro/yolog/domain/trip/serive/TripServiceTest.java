package com.pyro.yolog.domain.trip.serive;

import com.pyro.yolog.domain.member.query.AuthService;
import com.pyro.yolog.domain.trip.dto.TripRequest;
import com.pyro.yolog.domain.trip.entity.Trip;
import com.pyro.yolog.domain.trip.repository.TripRepository;
import com.pyro.yolog.domain.trip.service.TripService;
import com.pyro.yolog.support.database.LoginTest;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("TripService의")
public class TripServiceTest extends LoginTest {
    @Autowired
    private TripService tripService;

    @Autowired
    private TripRepository tripRepository;

    @Test
    @DisplayName("Trip을 생성할 수 있는가")
    void createTrip() {
        //given
        String name = "즐거운 여행";
        TripRequest request = new TripRequest(name, "싱가포르", "http://trip-url",
                LocalDateTime.of(2024, 7, 16, 15, 0),
                LocalDateTime.of(2024, 7, 20, 15, 0)
        );

        //when
        tripService.saveTrip(request);
        List<Trip> trips = tripRepository.findAllByMember(authService.getLoginUser());

        //then
        assertThat(trips.get(0).getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("Trip이 수정되는가")
    void updateTrip() {
        //given
        String updatedName = "행복한 여행";
        Trip trip = new Trip("즐거운 여행", "방구석", "http://trip-cover",
                LocalDateTime.of(2024, 7, 16, 15, 0),
                LocalDateTime.of(2024, 7, 20, 15, 0),
                authService.getLoginUser()
        );
        TripRequest request = new TripRequest(updatedName, "방구석", "http://trip-cover",
                LocalDateTime.of(2024, 7, 16, 15, 0),
                LocalDateTime.of(2024, 7, 20, 15, 0)
        );
        Long tripId = tripRepository.save(trip).getId();


        //when
        tripService.updateTrip(tripId, request);
        Trip updatedTrip = tripRepository.findById(tripId).orElseThrow(EntityNotFoundException::new);

        //then
        assertThat(updatedTrip.getName()).isEqualTo(updatedName);
    }

    @Test
    @DisplayName("Trip이 삭제되는가")
    void deleteTrip() {
        //given
        Trip trip = new Trip("짜파게티 여행", "방구석", "http://trip-cover",
                LocalDateTime.of(2024, 7, 16, 15, 0),
                LocalDateTime.of(2024, 7, 20, 15, 0),
                authService.getLoginUser()
        );
        Long id = tripRepository.save(trip).getId();

        //when
        tripService.deleteTrip(id);

        //then
        assertThat(tripRepository.findById(id)).isEmpty();
    }
}
