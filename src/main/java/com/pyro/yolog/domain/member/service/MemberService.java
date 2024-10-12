package com.pyro.yolog.domain.member.service;

import com.pyro.yolog.domain.member.dto.response.MemberRoleResponse;
import com.pyro.yolog.global.oauth2.service.AuthService;
import com.pyro.yolog.domain.member.dto.response.MemberSocialTypeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final AuthService authService;

    public MemberSocialTypeResponse getSocialType() {
        return new MemberSocialTypeResponse(authService.getLoginUser().getSocialType());
    }

    public MemberRoleResponse getRole() {
        return new MemberRoleResponse(authService.getLoginUser().getRole());
    }
}
