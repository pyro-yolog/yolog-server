package com.pyro.yolog.fixture.member;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.member.entity.Role;
import com.pyro.yolog.domain.member.entity.SocialType;
import com.pyro.yolog.domain.member.entity.Status;
import lombok.RequiredArgsConstructor;

public class MemberFixture {
    public final static Member MEMBER() {
        return Member.builder()
                .oauthId("12345")
                .nickname("이면지")
                .email("paper@daum.net")
                .password("12345678")
                .imageUrl("http://onesideusedpaper")
                .role(Role.USER)
                .socialType(SocialType.KAKAO)
                .status(Status.ACTIVE)
                .build();
    }
}
