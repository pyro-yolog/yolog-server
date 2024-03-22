package com.pyro.yolog.domain.memo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoRequest {
    private String title;
    private String content;
    private MultimediaRequest multimediaRequest;
}
