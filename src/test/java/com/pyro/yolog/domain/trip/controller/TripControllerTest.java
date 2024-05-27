package com.pyro.yolog.domain.trip.controller;

import com.pyro.yolog.domain.trip.api.TripController;
import com.pyro.yolog.domain.trip.service.TripService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.ResultActions;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.RequestEntity.post;


//@DisplayName("TripController의 ")
//@WebMvcTest(TripController.class)
//public class TripControllerTest extends RestDocsTest {
//    @MockBean
//    private TripService tripService;
//
//    @Test
//    @DisplayName("Trip이 저장 API가 수행되는가")
//    void saveTrip() {
//        //given
//
//        //when
//        ResultActions perform =
//                mockMvc.perform(
//                        post()
//                )
//    }
//}
