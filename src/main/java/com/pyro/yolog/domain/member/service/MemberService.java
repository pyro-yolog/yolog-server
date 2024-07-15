package com.pyro.yolog.domain.member.service;

import com.pyro.yolog.domain.auth.service.AuthService;
import com.pyro.yolog.domain.member.dto.response.SocialTypeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final AuthService authService;

    public SocialTypeResponse getSocialType() {
        return new SocialTypeResponse(authService.getLoginUser().getSocialType());
    }
}
