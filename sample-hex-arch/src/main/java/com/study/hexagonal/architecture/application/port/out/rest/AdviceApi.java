package com.study.hexagonal.architecture.application.port.out.rest;

import com.study.hexagonal.architecture.shared.dto.AdviceDto;

public interface AdviceApi {
    AdviceDto getAdviceById(Integer id);
}
