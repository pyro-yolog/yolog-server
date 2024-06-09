package com.pyro.yolog.domain.memo.dto;

import com.pyro.yolog.domain.memo.entity.MultimediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultimediaDto {
    String contentUrl;
    MultimediaType multimediaType;
}
