package com.pyro.yolog.domain.diary.mapper;

import com.pyro.yolog.domain.diary.dto.DiaryResponse;
import com.pyro.yolog.domain.diary.entity.Diary;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiaryMapper {

    DiaryResponse toResponse(Diary diary);
}
