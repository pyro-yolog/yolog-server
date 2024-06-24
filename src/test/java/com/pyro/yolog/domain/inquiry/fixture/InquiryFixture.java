package com.pyro.yolog.domain.inquiry.fixture;

import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.member.entity.Member;

public class InquiryFixture {
    public static Inquiry INQUIRY(Member member) {
        return Inquiry.builder()
                .content("여록 앱을 삭제하면 제 기록도 날아가나요?")
                .member(member)
                .build();
    }
}
