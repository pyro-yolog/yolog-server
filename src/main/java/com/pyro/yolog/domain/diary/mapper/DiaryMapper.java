package com.pyro.yolog.domain.diary.mapper;

import com.pyro.yolog.domain.diary.dto.request.CreateDiaryRequest;
import com.pyro.yolog.domain.diary.entity.Diary;
import com.pyro.yolog.domain.trip.entity.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiaryMapper {
    Diary toEntity(CreateDiaryRequest request, Trip trip);
}
