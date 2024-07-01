package com.pyro.yolog.domain.inquiry.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class DetailInquiryResponse {
    @Schema(description = "문의 ID")
    private Long id;
    private String title;
    private String content;
    @Schema(description = "문의에 대한 답변")
    private String answer;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    @Schema(description = "답변 완료되었는지 여부")
    private Boolean isAnswered;
}
