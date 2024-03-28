package com.pyro.yolog.domain.memo.service;

import com.pyro.yolog.domain.memo.dto.MultimediaDto;
import com.pyro.yolog.domain.memo.entity.Memo;
import com.pyro.yolog.domain.memo.mapper.MultimediaMapper;
import com.pyro.yolog.domain.memo.repository.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MultimediaService {
    private final MultimediaRepository multimediaRepository;
    private final MultimediaMapper multimediaMapper;

    @Transactional
    public void saveMultimedias(Memo memo, List<MultimediaDto> multimediaDtos) {
        multimediaDtos.forEach(media ->
                multimediaRepository.save(multimediaMapper.toEntity(memo, media)));
    }

    @Transactional(readOnly = true)
    public List<MultimediaDto> getMultimedias(Long memoId) {
        return multimediaRepository.findAllByMemoId(memoId).stream()
                .map(multimediaMapper::toResponse).collect(Collectors.toList());
    }

    public void deleteMultimedias(Memo memo) {
        multimediaRepository.deleteByMemo(memo);
    }
}
