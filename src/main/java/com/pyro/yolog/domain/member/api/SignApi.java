package com.pyro.yolog.domain.member.api;

import com.pyro.yolog.domain.member.dto.SignUpRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

public interface SignApi {
    @Operation(
            summary = "회원가입",
            description = "사용자의 닉네임을 입력받아 회원가입을 진행합니다. 중복된 닉네임이 입력되면 false를 반환합니다.",
            security = {@SecurityRequirement(name = "access_token")},
            tags = {"로그인"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "회원가입이 성공적으로 완료되었습니다."
            )
    })
    boolean signUp(@RequestBody SignUpRequest dto);

}
