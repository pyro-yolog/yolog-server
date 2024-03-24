package com.pyro.yolog.domain.memo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contentUrl;

    @Enumerated(EnumType.STRING)
    private MultimediaType multimediaType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memo_id")
    private Memo memo;

    @Builder
    public Multimedia(String contentUrl, MultimediaType multimediaType, Memo memo) {
        this.contentUrl = contentUrl;
        this.multimediaType = multimediaType;
        this.memo = memo;
    }

}
