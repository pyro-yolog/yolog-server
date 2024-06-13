package com.pyro.yolog.domain.trip.repository;

import com.pyro.yolog.domain.global.RepositoryTest;
import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.member.repository.MemberRepository;
import com.pyro.yolog.domain.trip.entity.Trip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.pyro.yolog.domain.trip.TripFixture.TRIP;
import static com.pyro.yolog.fixture.member.MemberFixture.MEMBER;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("TripRepository의 ")
@RepositoryTest
public class TripRepositoryTest {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private MemberRepository memberRepository;

    private Member member;

    @BeforeEach
    void setUp() {
        member = memberRepository.save(MEMBER());
    }

    @Test
    @DisplayName("")
    void getTripByMember() {
        //given
        Trip expect1 = tripRepository.save(TRIP(member));
        Trip expect2 = tripRepository.save(TRIP(member));

        //when
        List<Trip> results = tripRepository.findAllByMember(member);

        //then
        assertThat(results.size()).isEqualTo(2);
    }
}
