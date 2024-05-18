package com.pyro.yolog.domain.diary.repository;

import com.pyro.yolog.domain.diary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    Optional<Diary> findByTripAndTravelDate(Long tripId, LocalDateTime date);

    List<Diary> findByTripId(Long tripId);
}
