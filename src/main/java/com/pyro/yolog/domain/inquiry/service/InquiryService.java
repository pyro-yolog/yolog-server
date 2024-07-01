package com.pyro.yolog.domain.inquiry.service;

import com.pyro.yolog.domain.inquiry.dto.CreateInquiryImageDto;
import com.pyro.yolog.domain.inquiry.dto.request.InquiryRequest;
import com.pyro.yolog.domain.inquiry.dto.response.InquiryPreview;
import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.inquiry.mapper.InquiryMapper;
import com.pyro.yolog.domain.inquiry.repository.InquiryRepository;
import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InquiryService {
    private final AuthService authService;
    private final InquiryImageService inquiryImageService;
    private final InquiryRepository inquiryRepository;
    private final InquiryMapper inquiryMapper;

    @Transactional
    public void createInquiry(InquiryRequest request) {
        Member member = authService.getLoginUser();
        Inquiry inquiry = inquiryRepository.save(inquiryMapper
                .toEntity(member, request.getTitle(), request.getContent()));
        inquiryImageService.saveImages(
                new CreateInquiryImageDto(inquiry, request.getImageUrls()));
    }

    public List<InquiryPreview> getAllInquiries() {
        Member member = authService.getLoginUser();
        return inquiryRepository.findAllByMember(member).stream()
                .map(inquiryMapper::toResponse).collect(Collectors.toList());
    }
}
