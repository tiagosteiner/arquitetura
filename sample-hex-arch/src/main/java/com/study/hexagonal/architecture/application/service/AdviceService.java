package com.study.hexagonal.architecture.application.service;

import com.study.hexagonal.architecture.application.port.outbound.web.AdviceApiPort;
import com.study.hexagonal.architecture.shared.dto.Advice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdviceService {
    private final AdviceApiPort adviceApiPort;

    public ResponseEntity<Object> getAdvice(Integer adviceId) {
        var adviceFromApi = adviceApiPort.getAdviceById(adviceId);
        return createResponse(adviceFromApi);
    }

    private ResponseEntity<Object> createResponse(Advice advice) {
        if (advice.getSlip() != null) {
            return ResponseEntity.status(201).body(advice.getSlip());
        } else {
            return ResponseEntity.status(422).body(advice.getMessage());
        }
    }
}
