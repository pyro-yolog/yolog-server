package com.pyro.yolog.domain.inquiry.fixture;

import com.pyro.yolog.domain.inquiry.dto.response.DetailInquiryResponse;
import com.pyro.yolog.domain.inquiry.dto.response.InquiryPreview;
import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.member.entity.Member;

import java.time.LocalDateTime;

public class InquiryFixture {
    public static Inquiry INQUIRY_WITH_NO_ANSWER(Member member) {
        return Inquiry.builder()
                .title("안녕하세요. 개인 정보 관련하여 문의 드립니다.")
                .content("여록 앱을 삭제하면 제 기록도 날아가나요?")
                .member(member)
                .build();
    }

    public static InquiryPreview INQUIRY_PREVIEW_DTO() {
        return InquiryPreview.builder()
                .id(1L)
                .title("안녕하세요. 개인 정보 관련하여 문의 드립니다.")
                .createdAt(LocalDateTime.now())
                .isAnswered(false)
                .build();
    }

    public static DetailInquiryResponse DETAIL_INQUIRY_DTO() {
        return DetailInquiryResponse.builder()
                .id(1L)
                .title("안녕하세요. 개인 정보 관련하여 문의 드립니다.")
                .content("여록 앱을 삭제하면 제 기록도 날아가나요?")
                .answer("아니요. 앱을 삭제하여도 회원님의 개인 정보는 삭제되지 않습니다. 다만, 탈퇴를 할 경우, 회원님의 모든 개인 정보는 삭제됩니다.")
                .createdAt(LocalDateTime.now())
                .isAnswered(true)
                .build();
    }
}
