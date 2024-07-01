package com.pyro.yolog.domain.inquiry.mapper;

import com.pyro.yolog.domain.inquiry.dto.response.InquiryPreview;
import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InquiryMapper {
    Inquiry toEntity(Member member, String title, String content);

    InquiryPreview toResponse(Inquiry inquiry);
}
