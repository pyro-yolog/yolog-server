package com.pyro.yolog.domain.trip.entity;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.trip.dto.TripRequest;
import com.pyro.yolog.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private String coverImageUrl;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime finishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Trip(String name, String destination, String coverImageUrl, LocalDateTime startDate, LocalDateTime finishDate, Member member) {
        this.name = name;
        this.destination = destination;
        this.coverImageUrl = coverImageUrl;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.member = member;
    }

    public void update(TripRequest request) {
        this.name = request.getName();
        this.coverImageUrl = request.getCoverImageUrl();
        this.destination = request.getDestination();
        this.startDate = request.getStartDate();
        this.finishDate = request.getFinishDate();
    }
}
