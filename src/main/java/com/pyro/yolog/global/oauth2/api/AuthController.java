package com.pyro.yolog.global.oauth2.api;

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

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/social-login")
    public void login(@RequestBody LoginRequest request, HttpServletResponse response) {
        authService.authenticateOrRegisterUser(request, response);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/withdrawal")
    @Override
    public String withdrawMember() {
        authService.withdrawMember();
        return "redirect:https://yolog.store";
    }
}
