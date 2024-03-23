package com.pyro.yolog.support.database;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.member.query.AuthService;
import com.pyro.yolog.domain.member.repository.MemberRepository;
import com.pyro.yolog.fixture.member.MemberEntitiyFixture;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

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
        loginUser = memberRepository.save(MemberEntitiyFixture.LOGIN_MEMBER.toEntity());
        when(authService.getLoginUserId()).thenReturn(loginUser.getId());
        when(authService.getLoginUser()).thenReturn(loginUser);
    }
}
