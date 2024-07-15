package com.pyro.yolog.domain.auth.controller;

import com.pyro.yolog.domain.auth.service.AuthService;
import com.pyro.yolog.domain.auth.service.SignUpService;
import com.pyro.yolog.domain.member.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {
    private final AuthService authService;
    private final SignUpService signUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/social-login")
    public boolean signUp(@RequestBody SignUpRequest request) {
        return signUpService.signUp(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/withdrawal")
    @Override
    public void withdrawMember() {
        authService.withdrawMember();
    }
}
