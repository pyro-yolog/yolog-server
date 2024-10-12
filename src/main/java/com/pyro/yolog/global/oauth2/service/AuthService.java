package com.pyro.yolog.global.oauth2.service;

import com.pyro.yolog.domain.member.dto.request.SignUpRequest;
import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.member.entity.Role;
import com.pyro.yolog.domain.member.entity.SocialType;
import com.pyro.yolog.domain.member.entity.Status;
import com.pyro.yolog.domain.member.exception.MemberNotFoundException;
import com.pyro.yolog.domain.member.repository.MemberRepository;
import com.pyro.yolog.global.jwt.refresh.service.RefreshTokenService;
import com.pyro.yolog.global.oauth2.dto.LoginRequest;
import com.pyro.yolog.global.jwt.service.JwtService;
import com.pyro.yolog.global.oauth2.exception.InvalidNicknameException;
import com.pyro.yolog.global.oauth2.userInfo.OAuth2UserInfo;
import com.pyro.yolog.global.query.QueryService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Slf4j
@QueryService
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final OAuth2ProviderService oAuth2ProviderService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;

    @Value("${jwt.refresh.header}")
    private String refreshHeader;

    @Value("${oauth.kakao.admin-key}")
    private String kakaoAdminKey;

    @Value("${oauth.kakao.withdraw-uri}")
    private String kakaoWithdrawUri;

    public Long getLoginUserId() {
        return getLoginUser().getId();
    }

    public Member getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return memberRepository.findByEmail(username).orElseThrow(MemberNotFoundException::new);
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

    @Transactional
    public void authenticateOrRegisterGuest(LoginRequest loginRequest, HttpServletResponse response) {
        OAuth2UserInfo userInfo = oAuth2ProviderService.getUserInfo(loginRequest);
        Member member = findOrElseRegisterMember(userInfo, loginRequest.getSocialType());
        jwtService.sendAccessToken(response, member.getEmail());
    }

    private Member findOrElseRegisterMember(OAuth2UserInfo userInfo, SocialType socialType) {
        return memberRepository.findBySocialTypeAndOauthId(socialType, userInfo.getId())
                .orElseGet(() -> registerMember(socialType, userInfo));
    }

    private Member registerMember(SocialType socialType, OAuth2UserInfo userInfo) {
        Member member = Member.builder()
                .socialType(socialType)
                .oauthId(userInfo.getId())
                .email(userInfo.getEmail())
                .nickname(userInfo.getNickname())
                .imageUrl(userInfo.getImageUrl())
                .role(Role.GUEST)
                .status(Status.ACTIVE)
                .build();

        return memberRepository.save(member);
    }

    @Transactional
    public void signUp(SignUpRequest request, HttpServletResponse response) {
        if (memberRepository.existsByNickname(request.getNickname())) {
            throw new InvalidNicknameException();
        }

        Member member = getLoginUser();
        member.signUp(request);

        String refreshToken = jwtService.createRefreshToken();
        jwtService.setTokenHeader(response, refreshHeader, refreshToken);
        refreshTokenService.updateToken(member.getEmail(), refreshToken);
    }
}
