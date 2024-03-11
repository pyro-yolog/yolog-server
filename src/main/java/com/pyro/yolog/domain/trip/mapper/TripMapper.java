package com.pyro.yolog.domain.trip.mapper;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.trip.dto.SaveTripRequest;
import com.pyro.yolog.domain.trip.entity.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TripMapper {
    Trip toEntity(SaveTripRequest request, Member member);
}
