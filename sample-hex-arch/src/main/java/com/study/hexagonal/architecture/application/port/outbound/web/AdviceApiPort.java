package com.study.hexagonal.architecture.application.port.outbound.web;

import com.study.hexagonal.architecture.shared.dto.Advice;

public interface AdviceApiPort {
    Advice getAdviceById(Integer id);
}
