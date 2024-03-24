package com.pyro.yolog.domain.memo.mapper;

import com.pyro.yolog.domain.memo.dto.request.MultimediaRequest;
import com.pyro.yolog.domain.memo.entity.Memo;
import com.pyro.yolog.domain.memo.entity.Multimedia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MultimediaMapper {

    @Mapping(source = "memo", target = "memo")
    Multimedia toEntity(Memo memo, MultimediaRequest request);

}
