package com.pyro.yolog.domain.member.api;

import com.pyro.yolog.domain.member.dto.response.MemberRoleResponse;
import com.pyro.yolog.domain.member.dto.response.MemberSocialTypeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Member")
public interface MemberApi {
    @Operation(
            summary = "회원 Role 조회",
            description = "회원의 Role을 조회합니다.",
            security = {@SecurityRequirement(name = "access_token")}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK"
                    )
            }
    )
    MemberRoleResponse getRole();

    @Operation(
            summary = "회원 소셜 타입 조회",
            description = "회원이 로그인한 소셜 타입을 조회합니다.",
            security = {@SecurityRequirement(name = "access_token")}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK"
                    )
            }
    )
    MemberSocialTypeResponse getSocialType();
}
