package com.study.hexagonal.architecture.mock;

import com.study.hexagonal.architecture.application.dto.request.AdviceRequest;

public class AdviceRequestMock {
    public static AdviceRequest createValidAdviceRequest() {
        return new AdviceRequest(1);
    }

    public static AdviceRequest createInvalidAdviceRequest() {
        return new AdviceRequest(225);
    }
}
