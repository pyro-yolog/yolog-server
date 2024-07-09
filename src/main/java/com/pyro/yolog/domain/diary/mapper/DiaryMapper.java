package com.pyro.yolog.domain.diary.mapper;

import com.pyro.yolog.domain.diary.dto.response.DefaultDiaryResponse;
import com.pyro.yolog.domain.diary.dto.response.DetailDiaryResponse;
import com.pyro.yolog.domain.diary.dto.response.PreviewDiaryResponse;
import com.pyro.yolog.domain.diary.entity.Diary;
import com.pyro.yolog.domain.trip.entity.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.time.LocalDate;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiaryMapper {

    PreviewDiaryResponse toPreviewResponse(Diary diary);

    DetailDiaryResponse toDetailResponse(Diary diary);

    DefaultDiaryResponse toDefaultFormatResponse(Diary diary);

    Diary toEntity(Trip trip, String dayName, LocalDate travelDate);
}
