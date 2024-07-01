package com.pyro.yolog.domain.inquiry.fixture;

import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.member.entity.Member;

public class InquiryFixture {
    public static Inquiry INQUIRY_WITH_NO_ANSWER(Member member) {
        return Inquiry.builder()
                .title("안녕하세요. 개인 정보 관련하여 문의 드립니다.")
                .content("여록 앱을 삭제하면 제 기록도 날아가나요?")
                .member(member)
                .build();
    }
}
