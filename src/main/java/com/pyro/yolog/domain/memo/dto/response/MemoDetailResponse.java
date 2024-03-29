package com.pyro.yolog.domain.memo.dto.response;

import com.pyro.yolog.domain.memo.dto.MultimediaDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MemoDetailResponse {
    private String title;
    private String content;
    private LocalDateTime updatedAt;
    private List<MultimediaDto> multimediaDtos;
}
