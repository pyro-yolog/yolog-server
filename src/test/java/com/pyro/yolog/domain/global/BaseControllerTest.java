package com.pyro.yolog.domain.global;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyro.yolog.domain.member.entity.Member;
import com.pyro.yolog.domain.member.query.AuthService;
import com.pyro.yolog.domain.member.repository.MemberRepository;
import com.pyro.yolog.global.jwt.filter.JwtAuthenticationProcessingFilter;
import com.pyro.yolog.global.jwt.service.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.pyro.yolog.fixture.member.MemberFixture.MEMBER;


@WebMvcTest
public abstract class BaseControllerTest {
    protected final String MESSAGE = "$.message";
    protected final String ERROR_MESSAGE = "$.errorMessage";

    protected MockMvc mockMvc;
    protected String accessToken;
    protected Member loginMember;

    @SpyBean
    protected JwtService jwtService;
    @MockBean
    protected MemberRepository memberRepository;
    @SpyBean
    protected ObjectMapper objectMapper;

    protected String toRequestBody(Object value) throws JsonProcessingException {
        return objectMapper.writeValueAsString(value);
    }

    @BeforeEach
    public void loginSetup(WebApplicationContext ctx) {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilter(new JwtAuthenticationProcessingFilter(jwtService, memberRepository))
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
        loginMember = MEMBER();
        accessToken = jwtService.createAccessToken(loginMember.getEmail());
    }

}
