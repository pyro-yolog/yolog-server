package com.pyro.yolog.domain.inquiry.api;

import com.pyro.yolog.domain.global.BaseControllerTest;
import com.pyro.yolog.domain.inquiry.fixture.InquiryFixture;
import com.pyro.yolog.domain.inquiry.dto.request.InquiryRequest;
import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.inquiry.service.InquiryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.pyro.yolog.domain.inquiry.fixture.InquiryImageFixture.INQUIRY_IMAGE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("InquiryController의 ")
@WebMvcTest(InquiryController.class)
class InquiryControllerTest extends BaseControllerTest {
    @MockBean
    private InquiryService inquiryService;

    @Test
    @DisplayName("Inquiry 저장 API가 수행되는가")
    void createInquiry() throws Exception {
        //given
        Inquiry inquiry = InquiryFixture.INQUIRY_WITH_NO_ANSWER(loginMember);
        InquiryRequest request = new InquiryRequest(inquiry.getTitle(),
                inquiry.getContent(), List.of(INQUIRY_IMAGE().getImageUrl()));

        //when
        final ResultActions perform = mockMvc.perform(
                post("/inquiries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toRequestBody(request))
                        .header("Authorization", "Bearer " + accessToken)
        ).andDo(print());

        //then
        perform.andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Inquiry 저장 API에서 Request의 내용이 공백이면 예외가 발생하는가")
    void validCreateInquiry() throws Exception {
        //given
        InquiryRequest request = new InquiryRequest("문의하기 제목", " ",
                List.of(INQUIRY_IMAGE().getImageUrl()));

        //when
        final ResultActions perform = mockMvc.perform(
                post("/inquiries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toRequestBody(request))
                        .header("Authorization", "Bearer " + accessToken)
        ).andDo(print());

        //then
        perform.andExpect(status().isBadRequest());
    }
}
