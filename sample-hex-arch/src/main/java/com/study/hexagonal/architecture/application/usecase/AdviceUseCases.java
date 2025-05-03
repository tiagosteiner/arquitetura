package com.study.hexagonal.architecture.application.usecase;

import com.study.hexagonal.architecture.shared.dto.AdviceResponse;

public interface AdviceUseCases {
    AdviceResponse importAdvice(Integer adviceId);

    boolean validateRangeInterval(Integer adviceId);
}
