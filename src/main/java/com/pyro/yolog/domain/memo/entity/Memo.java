package com.pyro.yolog.domain.memo.entity;

import com.pyro.yolog.domain.memo.dto.request.MemoRequest;
import com.pyro.yolog.domain.trip.entity.Trip;
import com.pyro.yolog.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memo extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @OneToMany(mappedBy = "memo", orphanRemoval = true)
    private final List<Multimedia> multimedias = new ArrayList<>();

    @Builder
    public Memo(String title, String content, Trip trip) {
        this.title = title;
        this.content = content;
        this.trip = trip;
    }

    public void update(MemoRequest dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }
}
