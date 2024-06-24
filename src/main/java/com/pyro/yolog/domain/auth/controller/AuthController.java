package com.pyro.yolog.domain.auth.controller;

import com.pyro.yolog.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi{
    private final AuthService authService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/withdrawal")
    @Override
    public void withdrawMember() {
        authService.withdrawMember();
    }
}
