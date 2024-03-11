package com.pyro.yolog.domain.memo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemoType {
    DRAWING,
    RECORDING,
    PHOTO_VIDEO
}
