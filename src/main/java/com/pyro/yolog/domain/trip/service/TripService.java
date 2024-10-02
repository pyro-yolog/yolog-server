package com.pyro.yolog.domain.trip.service;

import com.pyro.yolog.domain.diary.service.DiaryService;
import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.global.oauth2.service.AuthService;
import com.pyro.yolog.domain.member.exception.OwnerNotEqualException;
import com.pyro.yolog.domain.trip.dto.request.TripRequest;
import com.pyro.yolog.domain.trip.dto.response.TripResponse;
import com.pyro.yolog.domain.trip.dto.response.DiaryOutOfDurationResponse;
import com.pyro.yolog.domain.trip.entity.Trip;
import com.pyro.yolog.domain.trip.mapper.TripMapper;
import com.pyro.yolog.domain.trip.repository.TripRepository;
import com.pyro.yolog.domain.trip.exception.TripNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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


    public DiaryOutOfDurationResponse checkDiaryOutOfDuration(Long id, LocalDate startDate, LocalDate finishDate) {
        final Trip trip = tripRepository.findById(id).orElseThrow(TripNotFoundException::new);
        return DiaryOutOfDurationResponse.builder()
                .isOutOfDuration(diaryService.checkDiaryOutOfDuration(trip, startDate, finishDate))
                .build();
    }

    @Transactional
    public void updateTrip(final Long id, final TripRequest request) {
        final Trip trip = tripRepository.findById(id).orElseThrow(TripNotFoundException::new);
        checkTripOwner(trip);
        trip.update(request);
        diaryService.deleteOutOfDuration(trip);
    }

    @Transactional
    public void deleteTrip(Long id) {
        checkTripOwner(getTrip(id));
        tripRepository.deleteById(id);
    }

    public List<TripResponse> getTrips() {
        Member login = authService.getLoginUser();
        return tripRepository.findAllByMember(login).stream()
                .map(TripResponse::new).collect(Collectors.toList());
    }

    public TripResponse getTripDetail(Long id) {
        return new TripResponse(getTrip(id));
    }

    public Trip getTrip(final Long id) {
        Trip trip = tripRepository.findById(id).orElseThrow(TripNotFoundException::new);
        checkTripOwner(trip);
        return trip;
    }

    private void checkTripOwner(Trip trip) {
        if (!trip.getMember().equals(authService.getLoginUser())) {
            throw new OwnerNotEqualException();
        }
    }
}
