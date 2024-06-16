package com.pyro.yolog.domain.global;

import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.member.repository.MemberRepository;
import com.pyro.yolog.global.jwt.service.JwtService;
import com.pyro.yolog.support.database.DatabaseCleanup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import io.restassured.RestAssured;

import static com.pyro.yolog.fixture.member.MemberFixture.MEMBER;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseApiTest {
    @Autowired
    private DatabaseCleanup databaseCleanup;
    @Autowired
    protected MemberRepository memberRepository;
    @Autowired
    private JwtService jwtService;

    @LocalServerPort
    int port;

    protected Member member;
    protected String accessToken;

    @BeforeEach
    public void setup() {
        if (RestAssured.port == RestAssured.UNDEFINED_PORT) {
            RestAssured.port = port;
            databaseCleanup.afterPropertiesSet();
        }
        member = memberRepository.save(MEMBER());
        accessToken = jwtService.createAccessToken(member.getEmail());
    }

    @AfterEach
    public void afterEach() {
        databaseCleanup.execute();
    }
}
