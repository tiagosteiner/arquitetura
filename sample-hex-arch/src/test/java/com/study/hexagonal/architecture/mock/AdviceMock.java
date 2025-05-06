package com.study.hexagonal.architecture.mock;

import com.study.hexagonal.architecture.domain.entity.Advice;

public class AdviceMock {
    public static Advice createValidAdviceEntity() {
        return new Advice(1, "Remember that spiders are more afraid of you, than you are of them.");
    }
}
