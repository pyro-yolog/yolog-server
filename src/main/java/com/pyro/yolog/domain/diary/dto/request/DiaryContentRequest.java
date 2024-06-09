package com.pyro.yolog.domain.diary.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaryContentRequest {
    private String content;
}
