package com.study.hexagonal.architecture.mock;

import com.study.hexagonal.architecture.application.dto.response.AdviceResponse;

public class AdviceResponseMock {
    public static AdviceResponse createAdviceResponseSuccess() {
        return new AdviceResponse(
                "Remember that spiders are more afraid of you, than you are of them.", null);
    }
}
