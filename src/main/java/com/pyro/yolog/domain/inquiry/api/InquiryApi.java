package com.pyro.yolog.domain.inquiry.api;

import com.pyro.yolog.domain.inquiry.dto.request.InquiryRequest;
import com.pyro.yolog.domain.inquiry.dto.response.DetailInquiryResponse;
import com.pyro.yolog.domain.inquiry.dto.response.InquiryPreview;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Inquiry")
public interface InquiryApi {
    @Operation(
            summary = "문의하기 등록",
            description = "문의하기를 등록합니다.",
            security = {@SecurityRequirement(name = "access_token")}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "문의가 성공적으로 등록되었습니다."
            )
    })
    void createInquiry(InquiryRequest request);

    @Operation(
            summary = "문의하기 전체 조회",
            description = "사용자가 제출한 문의를 전체 조회 합니다.",
            security = {@SecurityRequirement(name = "access_token")}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "문의하기 전체 조회에 성공했습니다."
            )
    })
    List<InquiryPreview> getAllInquiries();

    @Operation(
            summary = "문의하기 상세 조회",
            description = "문의 ID값으로 문의를 상세 조회합니다.",
            security = {@SecurityRequirement(name = "access_token")}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "문의하기 상세 조회에 성공했습니다."
            )
    })
    DetailInquiryResponse getDetailInquiry(
            @Parameter(in = ParameterIn.PATH, description = "문의 ID", required = true)
            Long id
    );
}
