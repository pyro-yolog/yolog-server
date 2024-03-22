package com.pyro.yolog.domain.trip.service;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.member.query.AuthService;
import com.pyro.yolog.domain.trip.dto.TripRequest;
import com.pyro.yolog.domain.trip.entity.Trip;
import com.pyro.yolog.domain.trip.mapper.TripMapper;
import com.pyro.yolog.domain.trip.repository.TripRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;
    private final AuthService authService;
    private final TripMapper tripMapper;

    @Transactional
    public void saveTrip(final TripRequest request) {
        Member login = authService.getMember();
        tripRepository.save(tripMapper.toEntity(request, login));
    }

    @Transactional
    public void updateTrip(final Long id, final TripRequest request) {
        final Trip trip = tripRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        trip.update(request);
    }

    @Transactional
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public Trip getTrip(final Long id) {
        return tripRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
