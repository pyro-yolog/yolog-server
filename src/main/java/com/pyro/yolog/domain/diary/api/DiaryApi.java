package com.pyro.yolog.domain.diary.api;

import com.pyro.yolog.domain.diary.dto.response.DefaultDiaryResponse;
import com.pyro.yolog.domain.diary.dto.response.DiaryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.time.LocalDateTime;

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

    @Operation(
            summary = "디폴트 일기 생성",
            description = "제목과 여행 날짜를 가진 일기를 생성합니다.",
            security = {@SecurityRequirement(name = "access_token")},
            tags = {"diary"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created"
                    )
            }
    )
    DefaultDiaryResponse createDefaultDiary(
            @Parameter(in = ParameterIn.PATH, description = "일기장 ID", required = true)
            Long tripId,

            @Parameter(in = ParameterIn.PATH, description = "일기 작성 날짜", required = true)
            LocalDateTime date
    );

}
