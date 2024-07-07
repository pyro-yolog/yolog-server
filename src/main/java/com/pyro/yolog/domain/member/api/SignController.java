package com.pyro.yolog.domain.member.api;

import com.pyro.yolog.domain.member.dto.SignUpRequest;
import com.pyro.yolog.domain.member.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SignController {
    private final SignUpService signUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/social-login")
    public boolean signUp(@RequestBody SignUpRequest request) {
        return signUpService.signUp(request);
    }
}
