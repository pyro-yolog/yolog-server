package com.pyro.yolog.domain.memo.api;

import com.pyro.yolog.domain.memo.dto.request.MemoRequest;
import com.pyro.yolog.domain.memo.dto.response.MemoDetailResponse;
import com.pyro.yolog.domain.memo.dto.response.MemoPreviewResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Memo")
public interface MemoApi {

    @Operation(
            summary = "빠른 메모 생성",
            description = "빠른 메모를 생성합니다.",
            security = {@SecurityRequirement(name = "access_token")}
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

    @Operation(
            summary = "빠른 메모 상세 조회",
            description = "빠른 메모를 상세 조회합니다.",
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
    MemoDetailResponse getMemo(
            @Parameter(in = ParameterIn.PATH, description = "일기장 ID", required = true)
            Long tripId,

            @Parameter(in = ParameterIn.PATH, description = "빠른 메모 ID", required = true)
            Long memoId
    );

    @Operation(
            summary = "빠른 메모 전체 조회",
            description = "일기장 별 빠른 메모를 모두 조회합니다.",
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
    List<MemoPreviewResponse> getMemos(
        @Parameter(in = ParameterIn.PATH, description = "일기장 ID", required = true)
        Long tripId
    );

    @Operation(
            summary = "빠른 메모 삭제",
            description = "빠른 메모를 삭제합니다.",
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
    void deleteMemo(@Parameter(in = ParameterIn.PATH, description = "일기장 ID", required = true)
                    Long tripId,
                    @Parameter(in = ParameterIn.PATH, description = "메모 ID", required = true)
                    Long memoId
    );

    @Operation(
            summary = "빠른 메모 수정",
            description = "빠른 메모를 수정합니다.",
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
    void updateMemo(@Parameter(in = ParameterIn.PATH, description = "일기장 ID", required = true)
                    Long tripId,

                    @Parameter(in = ParameterIn.PATH, description = "메모 ID", required = true)
                    Long memoId,

                    @RequestBody MemoRequest memoRequest
    );
}
