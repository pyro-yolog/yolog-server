package com.pyro.yolog.domain.diary.api;

import com.pyro.yolog.domain.diary.dto.request.PutDiaryContentRequest;
import com.pyro.yolog.domain.diary.dto.request.CreateDiaryRequest;
import com.pyro.yolog.domain.diary.dto.request.MoodRequest;
import com.pyro.yolog.domain.diary.dto.request.WeatherRequest;
import com.pyro.yolog.domain.diary.dto.response.DefaultDiaryResponse;
import com.pyro.yolog.domain.diary.dto.response.DetailDiaryResponse;
import com.pyro.yolog.domain.diary.dto.response.PreviewDiaryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Diary")
public interface DiaryApi {
    @Operation(
            summary = "일기 조회",
            description = "일기를 조회합니다.",
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
    DetailDiaryResponse getDiary(
            @Parameter(in = ParameterIn.PATH, description = "일기 ID", required = true)
            Long id
    );

    @Operation(
            summary = "특정 날짜의 일기 전체 조회",
            description = "특정 날짜의 일기장의 일기를 전체 조회합니다.",
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
    List<PreviewDiaryResponse> getDiaries(
            @Parameter(in = ParameterIn.PATH, description = "일기장 ID", required = true)
            Long tripId,

            @Parameter(in = ParameterIn.PATH, description = "여행 날짜", required = true)
            LocalDate date
    );


    @Operation(
            summary = "일기 생성",
            description = "일기를 생성합니다.",
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
    void createDiary(
            @Parameter(in = ParameterIn.PATH, description = "일기장 ID", required = true)
            Long tripId,

            CreateDiaryRequest request
    );

    @Operation(
            summary = "일기 수정",
            description = "일기를 수정합니다.",
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
    void updateDiaryTitleAndContent(
            @Parameter(in = ParameterIn.PATH, description = "일기 ID", required = true)
            Long id,

            @RequestBody(required = true) PutDiaryContentRequest request
    );

    @Operation(
            summary = "일기 삭제",
            description = "일기를 삭제합니다.",
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
    void deleteDiary(@Parameter(in = ParameterIn.PATH, description = "일기 ID", required = true)
                    Long id
    );

    @Operation(
            summary = "일기 날씨 수정",
            description = "일기의 날씨 정보를 수정합니다.",
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
    void updateWeather(
            @Parameter(in = ParameterIn.PATH, description = "일기 ID", required = true)
            Long id,

            @RequestBody(required = true) WeatherRequest request
    );

    @Operation(
            summary = "일기 기분 수정",
            description = "일기의 기분 정보를 수정합니다.",
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
    void updateMood(@Parameter(in = ParameterIn.PATH, description = "일기 ID", required = true)
                       Long id,

                       @RequestBody(required = true) MoodRequest request
    );
}
