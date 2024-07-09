package com.pyro.yolog.domain.diary.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaryDateRequest {
    @Schema(defaultValue = "2024-07-05",
            description = "해당 날짜를 기반으로 DAY가 정해집니다.")
    private LocalDate date;
}
