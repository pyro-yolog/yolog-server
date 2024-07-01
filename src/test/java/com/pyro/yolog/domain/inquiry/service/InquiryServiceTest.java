package com.pyro.yolog.domain.inquiry.service;

import com.pyro.yolog.domain.global.LoginTest;
import com.pyro.yolog.domain.inquiry.dto.request.InquiryRequest;
import com.pyro.yolog.domain.inquiry.dto.response.DetailInquiryResponse;
import com.pyro.yolog.domain.inquiry.dto.response.InquiryPreview;
import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.inquiry.entity.InquiryImage;
import com.pyro.yolog.domain.inquiry.repository.InquiryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.pyro.yolog.domain.inquiry.fixture.InquiryFixture.DETAIL_INQUIRY_DTO;
import static com.pyro.yolog.domain.inquiry.fixture.InquiryFixture.INQUIRY_WITH_NO_ANSWER;
import static com.pyro.yolog.domain.inquiry.fixture.InquiryImageFixture.INQUIRY_IMAGE;
import static com.pyro.yolog.fixture.member.MemberFixture.MEMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@DisplayName("InquiryService의")
@ExtendWith(MockitoExtension.class)
class InquiryServiceTest extends LoginTest {
    @MockBean
    private InquiryRepository inquiryRepository;
    @Autowired
    private InquiryService inquiryService;

    private Inquiry inquiry;
    private InquiryImage inquiryImage;

    @BeforeEach
    void setUp() {
        inquiry = INQUIRY_WITH_NO_ANSWER(MEMBER());
        inquiryImage = INQUIRY_IMAGE(inquiry);
    }

    @Test
    @DisplayName("Inquiry를 생성할 수 있는가")
    void saveInquiry() {
        //given
        int expect = 2;
        InquiryRequest request = new InquiryRequest(inquiry.getTitle(), inquiry.getContent(),
                List.of(inquiryImage.getImageUrl(), inquiryImage.getImageUrl()));

        //when
        for (int i = 0; i < expect; i++) {
            inquiryService.createInquiry(request);
        }

        //then
        List<Inquiry> inquiryResults = inquiryRepository.findAllByMember(loginUser);
        assertThat(inquiryResults).hasSize(expect);
    }

    @Test
    @DisplayName("Inquiry를 전체 조회할 수 있는가")
    void getAllInquiries() {
        //given
        int expect = 2;
        List<Inquiry> inquiries = new ArrayList<>();
        for (int i = 0; i < expect; i++) {
            inquiries.add(INQUIRY_WITH_NO_ANSWER(loginUser));
        }
        given(inquiryRepository.findAllByMember(loginUser)).willReturn(inquiries);

        //when
        List<InquiryPreview> result = inquiryService.getAllInquiries();

        //then
        assertThat(result).hasSize(expect);
    }

    @Test
    @DisplayName("Inquiry를 상세 조회할 수 있는가")
    void getDetailInquiry() {
        //given
        Inquiry inquiry = INQUIRY_WITH_NO_ANSWER(loginUser);
        given(inquiryRepository.findById(anyLong())).willReturn(Optional.of(inquiry));

        //when
        DetailInquiryResponse result = inquiryService.getDetailInquiry(1L);

        //then
        assertThat(result.getTitle()).isEqualTo(inquiry.getTitle());
    }

}
