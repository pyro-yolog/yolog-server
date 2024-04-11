package com.pyro.yolog.domain.trip.repository;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.trip.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findAllByMember(Member member);

}
