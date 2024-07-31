package com.pyro.yolog.domain.diary.dto.request;

import com.pyro.yolog.domain.diary.entity.Mood;
import com.pyro.yolog.domain.diary.entity.Weather;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateDiaryRequest {
    private String title;
    private String content;
    private Mood mood;
    private Weather weather;
}
