package com.pyro.yolog.domain.trip.serive;

import com.pyro.yolog.domain.global.LoginTest;
import com.pyro.yolog.domain.trip.dto.TripRequest;
import com.pyro.yolog.domain.trip.entity.Trip;
import com.pyro.yolog.domain.trip.repository.TripRepository;
import com.pyro.yolog.domain.trip.service.TripService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.pyro.yolog.domain.trip.TripFixture.TRIP;
import static com.pyro.yolog.fixture.member.MemberFixture.MEMBER;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("TripService의")
@ExtendWith(MockitoExtension.class)
class TripServiceTest extends LoginTest {
    @Autowired
    private TripService tripService;

    @Autowired
    private TripRepository tripRepository;

    private Trip trip;

    @BeforeEach
    void setUp() {
        trip = TRIP(MEMBER());
    }


    @Test
    @DisplayName("Trip을 생성할 수 있는가")
    void saveTrip() {
        //given
        TripRequest request = TripRequest.builder()
                .name(trip.getName())
                .destination(trip.getDestination())
                .coverImageUrl(trip.getCoverImageUrl())
                .startDate(trip.getStartDate())
                .finishDate(trip.getFinishDate()).build();

        //when
        tripService.saveTrip(request);
        List<Trip> trips = tripRepository.findAllByMember(loginUser);

        //then
        assertThat(trips.get(0).getName()).isEqualTo(trip.getName());
    }

    @Test
    @DisplayName("Trip을 수정할 수 있는가")
    void updateTrip() {
        //given
        String updatedName = "수정된 Trip Name";
        Long id = tripRepository.save(trip).getId();
        TripRequest request = TripRequest.builder()
                .name(updatedName)
                .destination(trip.getDestination())
                .coverImageUrl(trip.getCoverImageUrl())
                .startDate(trip.getStartDate())
                .finishDate(trip.getFinishDate()).build();

        //when
        tripService.updateTrip(id, request);

        //then
        assertThat(tripRepository.findById(id).get().getName()).isEqualTo(updatedName);
    }

    @Test
    @DisplayName("Trip을 삭제할 수 있는가")
    void deleteTrip() {
        //given
        Long id = tripRepository.save(trip).getId();

        //when
        tripService.deleteTrip(id);

        //then
        assertThat(tripRepository.findById(id).isPresent()).isFalse();
    }

    @Test
    @DisplayName("Trip을 ID로 조회할 수 있는가")
    void getTrip() {
        //given
        Long id = tripRepository.save(trip).getId();

        //when
        Trip result = tripService.getTrip(id);

        //then
        assertThat(result).isEqualTo(trip);
    }
}
