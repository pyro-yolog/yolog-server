package com.pyro.yolog.domain.diary.entity;

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

    @Column(columnDefinition = "TEXT")
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

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateWeather(Weather weather) {
        this.weather = weather;
    }

    public void updateMood(Mood mood) {
        this.mood = mood;
    }
}
