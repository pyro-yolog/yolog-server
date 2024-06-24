package com.pyro.yolog.domain.inquiry.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InquiryRequest {
    @Schema(description = "문의 내용입니다. 공백으로 제출하면 안됩니다.")
    @NotBlank
    private String content;

    @Schema(description = "문의사항에 참고되는 이미지 URL 입니다.")
    private List<String> imageUrls;

}
