package com.pyro.yolog.domain.member.query;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.member.repository.MemberRepository;
import com.pyro.yolog.global.jwt.service.JwtService;
import com.pyro.yolog.global.query.QueryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Slf4j
@QueryService
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final JwtService jwtService;

    public Long getMemberId() {
        return getMember().getId();
    }

    public Member getMember() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return memberRepository.findByEmail(userDetails.getUsername()).orElseThrow(EntityNotFoundException::new);
    }

}
