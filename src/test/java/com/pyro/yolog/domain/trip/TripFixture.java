package com.pyro.yolog.domain.trip;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.trip.entity.Trip;

import java.time.LocalDateTime;

public class TripFixture {
    public static Trip TRIP(Member member) {
        return Trip.builder()
                .name("마지막 힐링")
                .destination("하와이")
                .coverImageUrl("http://www.yolog.com/cover-image")
                .startDate(LocalDateTime.of(2024, 3, 21, 0, 0))
                .finishDate(LocalDateTime.of(2024, 3, 26, 0, 0))
                .member(member)
                .build();
    }

}
