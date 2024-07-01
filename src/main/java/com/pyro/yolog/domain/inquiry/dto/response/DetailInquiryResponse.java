package com.pyro.yolog.domain.inquiry.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;
    @Schema(description = "답변 완료되었는지 여부")
    private Boolean isAnswered;
}
