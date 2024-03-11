package com.pyro.yolog.domain.trip.entity;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.global.config.BaseTimeEntity;
import jakarta.persistence.*;
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

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
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
}
