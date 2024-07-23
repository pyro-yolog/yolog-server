package com.pyro.yolog.domain.diary.entity;

import com.pyro.yolog.domain.diary.dto.request.PutDiaryContentRequest;
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
    public Diary(Trip trip, LocalDate travelDate) {
        this.trip = trip;
        this.travelDate = travelDate;
    }

    public void updateTitleAndContent(PutDiaryContentRequest request) {
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
