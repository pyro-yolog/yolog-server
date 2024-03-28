package com.pyro.yolog.domain.memo.repository;

import com.pyro.yolog.domain.memo.entity.Memo;
import com.pyro.yolog.domain.memo.entity.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, Long> {
    List<Multimedia> findAllByMemoId(Long memoId);

    void deleteByMemo(Memo memo);
}
