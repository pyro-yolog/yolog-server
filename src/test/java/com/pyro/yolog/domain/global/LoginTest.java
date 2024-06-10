package com.pyro.yolog.domain.global;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.member.query.AuthService;
import com.pyro.yolog.domain.member.repository.MemberRepository;
import com.pyro.yolog.support.database.DatabaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.pyro.yolog.fixture.member.MemberFixture.MEMBER;
import static org.mockito.Mockito.when;

@DatabaseTest
public abstract class LoginTest {

    @MockBean
    protected AuthService authService;

    @Autowired
    protected MemberRepository memberRepository;
    protected Member loginUser;

    @BeforeEach
    public void setup() {
        loginUser = memberRepository.save(MEMBER());
        when(authService.getLoginUserId()).thenReturn(loginUser.getId());
        when(authService.getLoginUser()).thenReturn(loginUser);
    }
}
