package com.pyro.yolog.domain.trip.service;

import com.pyro.yolog.domain.diary.service.DiaryService;
import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.auth.service.AuthService;
import com.pyro.yolog.domain.trip.dto.TripRequest;
import com.pyro.yolog.domain.trip.dto.TripResponse;
import com.pyro.yolog.domain.trip.entity.Trip;
import com.pyro.yolog.domain.trip.mapper.TripMapper;
import com.pyro.yolog.domain.trip.repository.TripRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;
    private final AuthService authService;
    private final DiaryService diaryService;
    private final TripMapper tripMapper;

    @Transactional
    public void saveTrip(final TripRequest request) {
        Member login = authService.getLoginUser();
        tripRepository.save(tripMapper.toEntity(request, login));
    }

    @Transactional
    public void updateTrip(final Long id, final TripRequest request) {
        final Trip trip = tripRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        trip.update(request);
        diaryService.deleteOutOfDuration(trip);
    }

    @Transactional
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public Trip getTrip(final Long id) {
        return tripRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<TripResponse> getTrips() {
        Member login = authService.getLoginUser();
        return tripRepository.findAllByMember(login).stream()
                .map(TripResponse::new).collect(Collectors.toList());
    }
}
