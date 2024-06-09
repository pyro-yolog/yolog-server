package com.pyro.yolog.domain.memo.repository;

import com.pyro.yolog.domain.memo.entity.Memo;
import com.pyro.yolog.domain.trip.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByTripId(Long tripId);

}
