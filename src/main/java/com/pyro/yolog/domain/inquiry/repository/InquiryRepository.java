package com.pyro.yolog.domain.inquiry.repository;

import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    List<Inquiry> findAllByMember(Member member);
}
