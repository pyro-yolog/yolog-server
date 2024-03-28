package com.pyro.yolog.domain.memo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class MemoPreviewResponse {
    private Long memoId;
    private String title;
    private String content;
    private String multimediaUrl;
}
