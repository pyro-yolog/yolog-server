package com.pyro.yolog.domain.memo.repository;

import com.pyro.yolog.domain.memo.entity.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, Long> {
}
