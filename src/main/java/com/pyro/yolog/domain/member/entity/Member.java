package com.pyro.yolog.domain.member.entity;

import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.member.dto.request.SignUpRequest;
import com.pyro.yolog.domain.trip.entity.Trip;
import com.pyro.yolog.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oauthId;
    private String nickname;
    private String email;
    private String password;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Inquiry> inquiries;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Trip> trips;

    public void signUp(SignUpRequest dto) {
        this.nickname = dto.getNickname();
        this.role = Role.USER;
    }
}
