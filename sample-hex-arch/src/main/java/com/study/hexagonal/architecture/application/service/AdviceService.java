package com.study.hexagonal.architecture.application.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.study.hexagonal.architecture.application.port.outbound.rest.AdviceApiPort;
import com.study.hexagonal.architecture.domain.model.Advice;
import com.study.hexagonal.architecture.domain.repository.AdviceRepositoryPort;
import com.study.hexagonal.architecture.shared.dto.AdviceDto;

@Service
@RequiredArgsConstructor
public class AdviceService {
    private final AdviceApiPort adviceApiPort;
    private final AdviceRepositoryPort adviceRepositoryPort;

    public ResponseEntity<Object> importAdvice(Integer adviceId) {
        var adviceFromApi = adviceApiPort.getAdviceById(adviceId);
        if (adviceFromApi.getSlip() != null) {
            persistAdvice(adviceFromApi);
            return ResponseEntity.status(201).body(adviceFromApi.getSlip());
        } else {
            return ResponseEntity.status(422).body(adviceFromApi.getMessage());
        }
    }

    private void persistAdvice(AdviceDto adviceDto) {
        var adviceEntity =
                Advice.builder()
                        .id(adviceDto.getSlip().getId())
                        .adviceText(adviceDto.getSlip().getAdvice())
                        .build();
        adviceRepositoryPort.save(adviceEntity);
    }
}
