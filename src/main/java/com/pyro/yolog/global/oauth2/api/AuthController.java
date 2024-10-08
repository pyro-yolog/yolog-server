package com.pyro.yolog.global.oauth2.api;

import com.pyro.yolog.domain.member.dto.request.SignUpRequest;
import com.pyro.yolog.global.oauth2.dto.LoginRequest;
import com.pyro.yolog.global.oauth2.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {
    private final AuthService authService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/social-login")
    @Override
    public void login(@RequestBody LoginRequest request, HttpServletResponse response) {
        authService.authenticateOrRegisterGuest(request, response);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/social-login/sign-up")
    @Override
    public void signUp(@RequestBody SignUpRequest request, HttpServletResponse response) {
        authService.signUp(request, response);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/withdrawal")
    @Override
    public String withdrawMember() {
        authService.withdrawMember();
        return "redirect:https://yolog.store";
    }
}
