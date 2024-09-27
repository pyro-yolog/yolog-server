package com.pyro.yolog.domain.member.repository;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.member.entity.Role;
import com.pyro.yolog.domain.member.entity.SocialType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    
    Optional<Member> findBySocialTypeAndOauthId(SocialType socialType, String oauthId);

    boolean existsByNicknameAndRole(String nickname, Role role);
    boolean existsByNickname(String nickname);
}

