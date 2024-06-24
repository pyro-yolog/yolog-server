package com.pyro.yolog.domain.inquiry.service;

import com.pyro.yolog.domain.inquiry.dto.CreateInquiryImageDto;
import com.pyro.yolog.domain.inquiry.mapper.InquiryImageMapper;
import com.pyro.yolog.domain.inquiry.repository.InquiryImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InquiryImageService {
    private final InquiryImageRepository inquiryImageRepository;
    private final InquiryImageMapper inquiryImageMapper;

    @Transactional
    public void saveImages(CreateInquiryImageDto dto) {
        dto.getImageUrls().forEach(url -> inquiryImageRepository
                .save(inquiryImageMapper.toEntity(url, dto.getInquiry())));
    }
}
