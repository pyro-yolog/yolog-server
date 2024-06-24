package com.pyro.yolog.domain.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Auth")
public interface AuthApi {

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
    void withdrawMember();
}
