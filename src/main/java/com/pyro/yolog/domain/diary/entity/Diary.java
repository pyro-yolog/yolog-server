package com.pyro.yolog.domain.diary.entity;

import com.pyro.yolog.domain.diary.dto.request.UpdateDiaryContentRequest;
import com.pyro.yolog.domain.trip.entity.Trip;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // ㄷㅐ용량 string 으로 변경하는거 알아보기
    private String content;

    @Enumerated(EnumType.STRING)
    private Mood mood;
    @Enumerated(EnumType.STRING)
    private Weather weather;

    private LocalDate travelDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Builder
    public Diary(Trip trip, String title, String content, Mood mood, Weather weather, LocalDate travelDate) {
        this.trip = trip;
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.weather = weather;
        this.travelDate = travelDate;
    }

    public void updateTitleAndContent(UpdateDiaryContentRequest request) {
        this.content = request.getContent();
        this.title = request.getTitle();
    }

    public void updateWeather(Weather weather) {
        this.weather = weather;
    }

    public void updateMood(Mood mood) {
        this.mood = mood;
    }
}
