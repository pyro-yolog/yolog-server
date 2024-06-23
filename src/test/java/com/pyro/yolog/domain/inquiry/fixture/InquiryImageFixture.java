package com.pyro.yolog.domain.inquiry.fixture;

import com.pyro.yolog.domain.inquiry.entity.Inquiry;
import com.pyro.yolog.domain.inquiry.entity.InquiryImage;

public class InquiryImageFixture {
    public static InquiryImage INQUIRY_IMAGE() {
        return InquiryImage.builder()
                .imageUrl("https://inquiry/image1")
                .build();
    }

    public static InquiryImage INQUIRY_IMAGE(Inquiry inquiry) {
        return InquiryImage.builder()
                .inquiry(inquiry)
                .imageUrl("https://inquiry/image1")
                .build();
    }
}
