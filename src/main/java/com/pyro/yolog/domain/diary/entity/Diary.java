package com.pyro.yolog.domain.diary.entity;

import com.pyro.yolog.domain.diary.dto.request.DiaryContentRequest;
import com.pyro.yolog.domain.diary.dto.request.MoodRequest;
import com.pyro.yolog.domain.diary.dto.request.WeatherRequest;
import com.pyro.yolog.domain.trip.entity.Trip;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private Mood mood;
    @Enumerated(EnumType.STRING)
    private Weather weather;

    private LocalDateTime travelDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Builder
    public Diary(String title, LocalDateTime travelDate) {
        this.title = title;
        this.travelDate = travelDate;
    }

    public void updateContent(DiaryContentRequest request) {
        this.content = request.getContent();
    }

    public void updateWeather(WeatherRequest request) {
        this.weather = request.getWeather();
    }

    public void updateMood(MoodRequest request) {
        this.mood = request.getMood();
    }
}
