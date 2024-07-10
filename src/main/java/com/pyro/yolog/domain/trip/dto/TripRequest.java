package com.pyro.yolog.domain.trip.dto;

import com.pyro.yolog.domain.trip.entity.ColorCover;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripRequest {
    private String name;
    private String destination;

    @Schema(description = "이미지 커버입니다. URL 형식으로 입력되어야 합니다.")
    @URL
    private String coverImageUrl;

    @Schema(defaultValue = "ECD5E3", description = "색상 커버입니다. 지정된 색상 코드만 입력되어야 합니다.")
    private ColorCover colorCover;

    @Schema(defaultValue = "2024-07-05")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Schema(defaultValue = "2024-07-10")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDate;
}
