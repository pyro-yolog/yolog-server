package com.pyro.yolog.domain.diary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class DefaultDiaryResponse {
    private Long id;
    private String title;
    private LocalDateTime travelDate;
}
