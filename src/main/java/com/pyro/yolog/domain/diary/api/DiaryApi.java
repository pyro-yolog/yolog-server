package com.pyro.yolog.domain.diary.api;

import com.pyro.yolog.domain.diary.dto.DiaryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.time.LocalDateTime;
import java.util.List;

public interface DiaryApi {
    @Operation(
            summary = "일기 조회",
            description = "일기장의 일기를 조회합니다.",
            security = {@SecurityRequirement(name = "access_token")},
            tags = {"diary"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK"
                    )
            }
    )
    DiaryResponse getDiary(
            @Parameter(in = ParameterIn.PATH, description = "일기장 ID", required = true)
            Long tripId,

            @Parameter(in = ParameterIn.PATH, description = "여행 날짜", required = true)
            LocalDateTime date
    );

}
