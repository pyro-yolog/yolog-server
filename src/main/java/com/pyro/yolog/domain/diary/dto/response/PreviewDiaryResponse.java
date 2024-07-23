package com.pyro.yolog.domain.diary.dto.response;

import com.pyro.yolog.domain.diary.entity.Diary;
import com.pyro.yolog.domain.diary.entity.Mood;
import com.pyro.yolog.domain.diary.entity.Weather;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class PreviewDiaryResponse {
    private Long id;
    private String dayName;
    private String content;
    private String mood;
    private String weather;
    private LocalDate travelDate;

    public PreviewDiaryResponse(Diary diary) {
        this.id = diary.getId();
        this.content = diary.getContent();
        this.mood = getMood(diary.getMood());
        this.weather = getWeather(diary.getWeather());
        this.travelDate = diary.getTravelDate();
    }

    private String getMood(Mood mood) {
        if (mood == null) {
            return null;
        }
        return mood.getName();
    }

    private String getWeather(Weather weather) {
        if (weather == null) {
            return null;
        }
        return weather.getName();
    }
}
