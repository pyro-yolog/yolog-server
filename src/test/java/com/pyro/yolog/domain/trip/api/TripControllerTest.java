package com.pyro.yolog.domain.trip.api;

import com.pyro.yolog.domain.global.BaseControllerTest;
import com.pyro.yolog.domain.trip.TripFixture;
import com.pyro.yolog.domain.trip.dto.TripRequest;
import com.pyro.yolog.domain.trip.entity.Trip;
import com.pyro.yolog.domain.trip.repository.TripRepository;
import com.pyro.yolog.domain.trip.service.TripService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("TripController의 ")
@WebMvcTest(TripController.class)
class TripControllerTest extends BaseControllerTest {
    @MockBean
    private TripService tripService;
    @MockBean
    private TripRepository tripRepository;

    @BeforeEach
    void setTrip() throws Exception {
        //given
        Trip trip = TripFixture.TRIP(loginMember);
        TripRequest request = new TripRequest(trip.getName(), trip.getDestination(), trip.getCoverImageUrl(), trip.getStartDate(), trip.getFinishDate());

        //when
        final ResultActions perform = mockMvc.perform(
                post("/trips")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toRequestBody(request))
                        .header("Authorization", "Bearer " + accessToken)
        );
    }

    @Test
    @DisplayName("Trip 저장 API가 수행되는가")
    void saveTrip() throws Exception {
        //given
        Trip trip = TripFixture.TRIP(loginMember);
        TripRequest request = new TripRequest(trip.getName(), trip.getDestination(), trip.getCoverImageUrl(), trip.getStartDate(), trip.getFinishDate());

        //when
        final ResultActions perform = mockMvc.perform(
                post("/trips")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toRequestBody(request))
                        .header("Authorization", "Bearer " + accessToken)
        ).andDo(print());

        //then
        perform.andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Trip 수정 API가 수행되는가")
    void updateTrip() throws Exception {
        //given
        Trip trip = TripFixture.TRIP(loginMember);
        TripRequest request = new TripRequest(trip.getName(), trip.getDestination(), trip.getCoverImageUrl(), trip.getStartDate(), trip.getFinishDate());

        //when
        final ResultActions perform = mockMvc.perform(
                put("/trips/" + 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toRequestBody(request))
                        .header("Authorization", "Bearer " + accessToken)
        ).andDo(print());

        //then
        perform.andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Trip 삭제 API가 수행되는가")
    void deleteTrip() throws Exception {
        //when
        final ResultActions perform = mockMvc.perform(
                delete("/trips/" + 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + accessToken)
        ).andDo(print());

        //then
        perform.andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Trip 전체 조회 API가 수행되는가")
    void getAllTrips() throws Exception {
        //when
        final ResultActions perform = mockMvc.perform(
                get("/trips")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + accessToken)
        ).andDo(print());

        //then
        perform.andExpect(status().isOk());
    }
}
