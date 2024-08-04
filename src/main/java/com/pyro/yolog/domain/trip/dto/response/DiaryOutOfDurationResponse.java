package com.pyro.yolog.domain.trip.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "수정될 일기장 여행 기간을 넘어가는 일기가 존재하는지 여부")
@Getter
@NoArgsConstructor
public class DiaryOutOfDurationResponse {
    private boolean isOutOfDuration;

    @Builder
    public DiaryOutOfDurationResponse(boolean isOutOfDuration) {
        this.isOutOfDuration = isOutOfDuration;
    }
}
