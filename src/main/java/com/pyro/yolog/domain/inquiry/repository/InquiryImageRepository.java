package com.pyro.yolog.domain.inquiry.repository;

import com.pyro.yolog.domain.inquiry.entity.InquiryImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryImageRepository extends JpaRepository<InquiryImage, Long> {

}
