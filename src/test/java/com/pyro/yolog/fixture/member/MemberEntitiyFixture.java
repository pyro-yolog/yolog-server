package com.pyro.yolog.fixture.member;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.member.entity.Role;
import com.pyro.yolog.domain.member.entity.SocialType;
import com.pyro.yolog.domain.member.entity.Status;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MemberEntitiyFixture {
    LOGIN_MEMBER("12345", "이면지", "paper@daum.net", "12345678", "http://onesideusedpaper", "HiruByeru", Role.USER, SocialType.KAKAO, Status.ACTIVE);

    private final String oauthId;
    private final String nickname;
    private final String email;
    private final String password;
    private final String imageUrl;
    private final String refreshToken;
    private final Role role;
    private final SocialType socialType;
    private final Status status;

    public Member toEntity() {
        return Member.builder()
                .oauthId(oauthId)
                .nickname(nickname)
                .email(email)
                .password(password)
                .imageUrl(imageUrl)
                .refreshToken(refreshToken)
                .role(role)
                .socialType(socialType)
                .status(status)
                .build();
    }

}
