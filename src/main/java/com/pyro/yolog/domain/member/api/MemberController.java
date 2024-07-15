package com.pyro.yolog.domain.member.api;

import com.pyro.yolog.domain.member.dto.response.SocialTypeResponse;
import com.pyro.yolog.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberController {
    private final MemberService memberService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("social-type")
    public SocialTypeResponse getSocialType() {
        return memberService.getSocialType();
    }
}
