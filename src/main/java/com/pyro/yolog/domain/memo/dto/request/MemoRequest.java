package com.pyro.yolog.domain.memo.dto.request;

import com.pyro.yolog.domain.memo.dto.MultimediaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoRequest {
    private String title;
    private String content;
    private List<MultimediaDto> multimediaDtos;
}
