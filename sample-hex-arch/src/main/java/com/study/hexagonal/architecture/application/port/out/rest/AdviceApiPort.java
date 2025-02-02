package com.study.hexagonal.architecture.application.port.out.rest;

import com.study.hexagonal.architecture.shared.dto.AdviceDto;

public interface AdviceApiPort {
    AdviceDto getAdviceById(Integer id);
}
