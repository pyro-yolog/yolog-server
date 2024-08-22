package com.pyro.yolog.domain.trip.entity;

import com.pyro.yolog.domain.diary.entity.Diary;
import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.trip.dto.request.TripRequest;
import com.pyro.yolog.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Trip extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String destination;

    @Column(columnDefinition = "TEXT")
    private String coverImageUrl;

    @Enumerated(EnumType.STRING)
    private CoverColor coverColor;

    @Enumerated(EnumType.STRING)
    private SpineColor spineColor;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate finishDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Diary> diaries;

    @Builder
    public Trip(String name, String destination, String coverImageUrl, CoverColor coverColor, SpineColor spineColor, LocalDate startDate, LocalDate finishDate, Member member) {
        this.name = name;
        this.destination = destination;
        this.coverImageUrl = coverImageUrl;
        this.coverColor = coverColor;
        this.spineColor = spineColor;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.member = member;
    }

    public void update(TripRequest request) {
        this.name = request.getName();
        this.coverImageUrl = request.getCoverImageUrl();
        this.coverColor = request.getCoverColor();
        this.spineColor = request.getSpineColor();
        this.destination = request.getDestination();
        this.startDate = request.getStartDate();
        this.finishDate = request.getFinishDate();
    }
}
