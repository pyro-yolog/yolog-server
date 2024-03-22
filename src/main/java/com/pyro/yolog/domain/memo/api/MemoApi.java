package com.pyro.yolog.domain.memo.api;

import com.pyro.yolog.domain.memo.dto.request.MemoRequest;
import com.pyro.yolog.domain.memo.dto.request.MultimediaRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

public interface MemoApi {

    @Operation(
            summary = "빠른 메모 생성",
            description = "빠른 메모를 생성합니다.",
            security = {@SecurityRequirement(name = "access_token")},
            tags = {"memo"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created"
                    )
            }
    )
    void saveMemo(@Parameter(in = ParameterIn.PATH, description = "일기장 ID", required = true)
                  Long tripId,

                  @RequestBody MemoRequest memoRequest
    );
}
