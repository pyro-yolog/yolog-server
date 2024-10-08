package com.pyro.yolog.domain.member.api;

import com.pyro.yolog.domain.member.dto.response.MemberRoleResponse;
import com.pyro.yolog.domain.member.dto.response.MemberSocialTypeResponse;
import com.pyro.yolog.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberController implements MemberApi{
    private final MemberService memberService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/role")
    public MemberRoleResponse getRole() {
        return memberService.getRole();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/social-type")
    @Override
    public MemberSocialTypeResponse getSocialType() {
        return memberService.getSocialType();
    }
}
