package com.pyro.yolog.global.oauth2.api;

import com.pyro.yolog.global.oauth2.dto.LoginRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

@Tag(name = "Auth")
public interface AuthApi {

    @Operation(
            summary = "회원가입",
            description = "사용자의 닉네임을 입력받아 회원가입을 진행합니다. 중복된 닉네임이 입력되면 false를 반환합니다.",
            security = {@SecurityRequirement(name = "access_token")}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "회원가입이 성공적으로 완료되었습니다."
            )
    })
    void login(LoginRequest request, HttpServletResponse response);


    @Operation(
            summary = "회원 탈퇴",
            description = "회원을 탈퇴합니다. 연결된 소셜과의 연결이 끊깁니다.",
            security = {@SecurityRequirement(name = "access_token")}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "No Content"
                    )
            }
    )
    String withdrawMember();
}
