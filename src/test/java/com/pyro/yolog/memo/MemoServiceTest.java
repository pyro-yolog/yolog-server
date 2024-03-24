package com.pyro.yolog.memo;

import com.pyro.yolog.domain.member.query.AuthService;
import com.pyro.yolog.domain.memo.dto.request.MemoRequest;
import com.pyro.yolog.domain.memo.dto.request.MultimediaRequest;
import com.pyro.yolog.domain.memo.entity.Memo;
import com.pyro.yolog.domain.memo.entity.Multimedia;
import com.pyro.yolog.domain.memo.entity.MultimediaType;
import com.pyro.yolog.domain.memo.repository.MemoRepository;
import com.pyro.yolog.domain.memo.repository.MultimediaRepository;
import com.pyro.yolog.domain.memo.service.MemoService;
import com.pyro.yolog.domain.trip.entity.Trip;
import com.pyro.yolog.domain.trip.repository.TripRepository;
import com.pyro.yolog.support.database.LoginTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DisplayName("MemoService의")
public class MemoServiceTest extends LoginTest {
    @Autowired
    private AuthService authService;
    @Autowired
    private MemoService memoService;
    @Autowired
    private MemoRepository memoRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private MultimediaRepository multimediaRepository;

    @Test
    @DisplayName("메모를 생성할 수 있는가")
    void createMemo() {
        //given
        Trip trip = new Trip(
                "여유로운 여행",
                "방콕",
                "http://cover-images",
                LocalDateTime.of(2024, 7, 16, 15, 0),
                LocalDateTime.now(),
                authService.getLoginUser()
        );
        Long tripId = tripRepository.save(trip).getId();

        MemoRequest request = new MemoRequest(
               "Memo Title",
               "Memo Content",
               new MultimediaRequest(
                       "http://multimediaurl",
                       MultimediaType.PHOTO_VIDEO
               )
        );

        //when
        memoService.saveMemo(tripId, request);

        List<Memo> memos = memoRepository.findAllByTrip(trip);
        List<Multimedia> multimedias = multimediaRepository.findAllByMemo(memos.get(0));

        //then
        assertThat(memos.get(0).getTitle()).isEqualTo("Memo Title");
        assertThat(multimedias.get(0).getMultimediaType()).isEqualTo(MultimediaType.PHOTO_VIDEO);
    }
}
