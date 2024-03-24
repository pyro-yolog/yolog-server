package com.pyro.yolog.domain.memo.mapper;

import com.pyro.yolog.domain.memo.dto.request.MemoRequest;
import com.pyro.yolog.domain.memo.entity.Memo;
import com.pyro.yolog.domain.trip.entity.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MemoMapper {

    @Mapping(source = "trip", target = "trip")
    Memo toEntity(Trip trip, MemoRequest request);

}
