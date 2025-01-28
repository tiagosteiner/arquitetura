package com.study.hexagonal.architecture.application.service;

import com.study.hexagonal.architecture.application.port.outbound.web.AdviceApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdviceService {
    private final AdviceApiPort adviceApiPort;

    public ResponseEntity<Object> getAdvice(Integer adviceId) {
        var adviceFinded = adviceApiPort.getAdviceById(adviceId);

        if (adviceFinded.getSlip() != null) {
            return ResponseEntity.status(201).body(adviceFinded.getSlip());
        } else {
            return ResponseEntity.status(422).body(adviceFinded.getMessage());
        }
    }
}
