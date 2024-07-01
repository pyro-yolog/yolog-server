package com.pyro.yolog.domain.inquiry.entity;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inquiry extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String answer;

    @Column(nullable = false)
    @ColumnDefault("false")
    private Boolean isAnswered;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Inquiry(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }
}
