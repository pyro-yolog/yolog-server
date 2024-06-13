package com.pyro.yolog.domain.trip.controller;

import com.pyro.yolog.domain.global.BaseControllerTest;
import com.pyro.yolog.domain.trip.TripFixture;
import com.pyro.yolog.domain.trip.api.TripController;
import com.pyro.yolog.domain.trip.dto.TripRequest;
import com.pyro.yolog.domain.trip.entity.Trip;
import com.pyro.yolog.domain.trip.repository.TripRepository;
import com.pyro.yolog.domain.trip.service.TripService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("TripController의 ")
@WebMvcTest(TripController.class)
public class TripControllerTest extends BaseControllerTest {
    @MockBean
    private TripService tripService;

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
}
