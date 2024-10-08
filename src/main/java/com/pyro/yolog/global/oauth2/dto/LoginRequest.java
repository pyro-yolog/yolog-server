package com.pyro.yolog.global.oauth2.dto;

import com.pyro.yolog.domain.member.entity.SocialType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "로그인 포맷")
public class LoginRequest {
    @Schema(description = "인증서버에서 받아온 access token을 입력")
    private String token;
    @Schema(description = "인증서버타입, GOOGLE, KAKAO 가능", defaultValue = "KAKAO")
    private SocialType socialType;
}

