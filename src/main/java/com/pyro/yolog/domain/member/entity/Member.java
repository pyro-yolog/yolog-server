package com.pyro.yolog.domain.member.entity;

import com.pyro.yolog.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oauthId;  //로그인한 소셜 타입의 식별자 값
    private String nickname;
    private String email;
    private String password;
    private String imageUrl;

    private String refreshToken;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private Status status;
}
