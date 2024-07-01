package com.pyro.yolog.domain.inquiry.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class InquiryPreview {
    private String title;
    private LocalDateTime createdAt;
    private Boolean isAnswered;
}
