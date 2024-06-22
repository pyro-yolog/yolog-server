package com.pyro.yolog.global.s3.api;

import com.pyro.yolog.global.s3.dto.S3ImageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.multipart.MultipartFile;

public interface S3ImageApi {
    @Operation(
            summary = "이미지 업로드",
            description = "S3에 이미지를 업로드합니다. 해당 이미지의 URL을 반환받습니다.",
            security = {@SecurityRequirement(name = "access_token")},
            tags = {"IMAGE"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created"
            )
    })
    S3ImageDto uploadImage(MultipartFile image);

    @Operation(
            summary = "이미지 삭제",
            description = "S3에서 이미지를 삭제합니다.",
            security = {@SecurityRequirement(name = "access_token")},
            tags = {"IMAGE"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "No Content"
            )
    })
    void deleteImage(S3ImageDto dto);
}
