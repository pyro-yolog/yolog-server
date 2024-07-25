package com.pyro.yolog.domain.diary.dto.response;

import com.pyro.yolog.domain.diary.entity.Diary;
import com.pyro.yolog.domain.diary.entity.Mood;
import com.pyro.yolog.domain.diary.entity.Weather;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class DetailDiaryResponse {
    private Long id;
    private String dayName;
    private String title;
    private String content;
    private String mood;
    private String weather;
    private LocalDate travelDate;

    public DetailDiaryResponse(Diary diary) {
        this.id = diary.getId();
        this.title = diary.getTitle();
        this.content = diary.getContent();
        this.mood = getMood();
        this.weather = getWeather();
        this.travelDate = diary.getTravelDate();
    }
}
