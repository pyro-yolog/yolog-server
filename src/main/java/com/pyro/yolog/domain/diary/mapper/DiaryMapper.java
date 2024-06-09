package com.pyro.yolog.domain.diary.mapper;

import com.pyro.yolog.domain.diary.dto.response.DefaultDiaryResponse;
import com.pyro.yolog.domain.diary.dto.response.DiaryResponse;
import com.pyro.yolog.domain.diary.entity.Diary;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.time.LocalDateTime;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiaryMapper {

    DiaryResponse toResponse(Diary diary);

    DefaultDiaryResponse toDefaultFormatResponse(Diary diary);

    Diary toEntity(String title, LocalDateTime travelDate);
}
