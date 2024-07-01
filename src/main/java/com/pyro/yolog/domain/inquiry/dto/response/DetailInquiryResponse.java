package com.pyro.yolog.domain.inquiry.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class DetailInquiryResponse {
    private Long id;
    private String title;
    private String content;
    private String answer;
    private LocalDateTime createdAt;
    private Boolean isAnswered;
}
