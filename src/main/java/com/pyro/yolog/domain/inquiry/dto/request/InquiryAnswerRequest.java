package com.pyro.yolog.domain.inquiry.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InquiryAnswerRequest {
    @Schema(description = "답변 내용입니다. 공백으로 제출하면 안됩니다.")
    @NotBlank
    private String answer;
}
