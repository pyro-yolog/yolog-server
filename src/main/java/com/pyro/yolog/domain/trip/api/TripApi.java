package com.pyro.yolog.domain.trip.api;

import com.pyro.yolog.domain.memo.dto.response.MemoPreviewResponse;
import com.pyro.yolog.domain.trip.dto.TripRequest;
import com.pyro.yolog.domain.trip.dto.TripResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

public interface TripApi {

    @Operation(
            summary = "일기장 생성",
            description = "일기장을 생성합니다.",
            security = {@SecurityRequirement(name = "access_token")},
            tags = {"trip"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created"
            )
    })
    void saveTrip(@RequestBody TripRequest request);

    @Operation(
            summary = "일기장 수정",
            description = "일기장을 수정합니다",
            security = {@SecurityRequirement(name = "access_token")},
            tags = {"trip"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "No Content"
            )
    })
    void updateTrip(
            @Parameter(in = ParameterIn.QUERY, description = "일기장 ID", required = true)
            Long id,

            @RequestBody TripRequest request
    );

    @Operation(
            summary = "일기장 삭제",
            description = "일기장을 삭제합니다.",
            security = {@SecurityRequirement(name = "access_token")},
            tags = {"trip"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "No Content"
            )
    })
    void deleteTrip(
            @Parameter(in = ParameterIn.QUERY, description = "일기장 ID", required = true)
            Long id
    );

    @Operation(
            summary = "일기장 전체 조회",
            description = "회원별 일기장을 모두 조회합니다.",
            security = {@SecurityRequirement(name = "access_token")},
            tags = {"trip"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK"
                    )
            }
    )
    List<TripResponse> getTrips();

}
