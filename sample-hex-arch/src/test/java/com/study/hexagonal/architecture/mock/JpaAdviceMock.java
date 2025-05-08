package com.study.hexagonal.architecture.mock;

import com.study.hexagonal.architecture.adapter.out.entity.JpaAdvice;

public class JpaAdviceMock {
    public static JpaAdvice createValidJpaAdviceEntity() {
        return new JpaAdvice(1, "Remember that spiders are more afraid of you, than you are of them.");
    }
}
