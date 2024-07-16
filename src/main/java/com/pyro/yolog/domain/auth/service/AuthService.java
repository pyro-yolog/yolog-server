package com.pyro.yolog.domain.auth.service;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.member.entity.SocialType;
import com.pyro.yolog.domain.member.exception.MemberNotFoundException;
import com.pyro.yolog.domain.member.repository.MemberRepository;
import com.pyro.yolog.global.jwt.service.JwtService;
import com.pyro.yolog.global.query.QueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Slf4j
@QueryService
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final JwtService jwtService;


    @Value("${oauth.kakao.admin-key}")
    private String kakaoAdminKey;

    @Value("${oauth.kakao.withdraw-uri}")
    private String kakaoWithdrawUri;

    public Long getLoginUserId() {
        return getLoginUser().getId();
    }

    public Member getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return memberRepository.findByEmail(userDetails.getUsername()).orElseThrow(MemberNotFoundException::new);
    }


    @Transactional
    public void withdrawMember() {
        Member member = getLoginUser();
        if (member.getSocialType().equals(SocialType.KAKAO)) {
            sendWithdrawRequestToKakao(SocialType.KAKAO, member);
        }
        deleteMemberAccount(member);
    }

    private void sendWithdrawRequestToKakao(SocialType socialType, Member member) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "KakaoAK " + kakaoAdminKey);
        String data = "target_id_type=user_id" +
                "&target_id=" + member.getOauthId();
        HttpEntity <String> httpEntity = new HttpEntity<>(data, headers);
        ResponseEntity<String> response = restTemplate.exchange(kakaoWithdrawUri, HttpMethod.POST, httpEntity, String.class);
    }

    private void deleteMemberAccount(Member member) {
        memberRepository.delete(member);
    }
}
