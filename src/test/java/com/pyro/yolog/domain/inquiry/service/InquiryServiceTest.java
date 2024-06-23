package com.pyro.yolog.domain.inquiry.service;

import com.pyro.yolog.domain.global.LoginTest;
import com.pyro.yolog.domain.inquiry.dto.request.InquiryRequest;
import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.inquiry.entity.InquiryImage;
import com.pyro.yolog.domain.inquiry.repository.InquiryImageRepository;
import com.pyro.yolog.domain.inquiry.repository.InquiryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.pyro.yolog.domain.inquiry.fixture.InquiryFixture.INQUIRY;
import static com.pyro.yolog.domain.inquiry.fixture.InquiryImageFixture.INQUIRY_IMAGE;
import static com.pyro.yolog.fixture.member.MemberFixture.MEMBER;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("InquiryService의")
@ExtendWith(MockitoExtension.class)
class InquiryServiceTest extends LoginTest {
    @Autowired
    private InquiryRepository inquiryRepository;
    @Autowired
    private InquiryService inquiryService;

    private Inquiry inquiry;
    private InquiryImage inquiryImage;

    @BeforeEach
    void setUp() {
        inquiry = INQUIRY(MEMBER());
        inquiryImage = INQUIRY_IMAGE(inquiry);
    }

    @Test
    @DisplayName("Inquiry를 생성할 수 있는가")
    void saveInquiry() {
        //given
        int expect = 2;
        InquiryRequest request = new InquiryRequest(inquiry.getContent(),
                List.of(inquiryImage.getImageUrl(), inquiryImage.getImageUrl()));

        //when
        for (int i = 0; i < expect; i++) {
            inquiryService.createInquiry(request);
        }

        //then
        List<Inquiry> inquiryResults = inquiryRepository.findAllByMember(loginUser);
        assertThat(inquiryResults).hasSize(expect);
    }
}
