package com.pyro.yolog.domain.inquiry.api;

import com.pyro.yolog.domain.inquiry.dto.request.InquiryRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "문의하기")
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
}
