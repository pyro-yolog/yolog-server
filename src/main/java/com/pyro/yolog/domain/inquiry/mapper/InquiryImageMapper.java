package com.pyro.yolog.domain.inquiry.mapper;

import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.inquiry.entity.InquiryImage;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InquiryImageMapper {
    InquiryImage toEntity(String imageUrl, Inquiry inquiry);
}
