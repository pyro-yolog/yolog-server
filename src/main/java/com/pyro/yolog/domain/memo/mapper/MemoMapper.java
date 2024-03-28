package com.pyro.yolog.domain.memo.mapper;

import com.pyro.yolog.domain.memo.dto.MultimediaDto;
import com.pyro.yolog.domain.memo.dto.request.MemoRequest;
import com.pyro.yolog.domain.memo.dto.response.MemoDetailResponse;
import com.pyro.yolog.domain.memo.dto.response.MemoPreviewResponse;
import com.pyro.yolog.domain.memo.entity.Memo;
import com.pyro.yolog.domain.trip.entity.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MemoMapper {

    @Mapping(source = "trip", target = "trip")
    Memo toEntity(Trip trip, MemoRequest request);

    @Mapping(source = "memo.title", target = "title")
    @Mapping(source = "memo.content", target = "content")
    @Mapping(source = "multimediaDtos", target = "multimediaDtos")
    MemoDetailResponse toDetailResponse(Memo memo, List<MultimediaDto> multimediaDtos);

    MemoPreviewResponse toPreviewResponse(Memo, )

}
