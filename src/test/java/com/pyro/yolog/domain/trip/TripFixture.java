package com.pyro.yolog.domain.trip;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.trip.entity.Trip;

import java.time.LocalDate;

public class TripFixture {
    public static Trip TRIP(Member member) {
        return Trip.builder()
                .name("마지막 힐링")
                .destination("하와이")
                .coverImageUrl("http://www.yolog.com/cover-image")
                .startDate(LocalDate.of(2024, 3, 21))
                .finishDate(LocalDate.of(2024, 3, 26))
                .member(member)
                .build();
    }

}
