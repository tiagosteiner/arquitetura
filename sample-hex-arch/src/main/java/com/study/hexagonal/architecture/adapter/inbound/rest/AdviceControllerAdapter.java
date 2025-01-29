package com.study.hexagonal.architecture.adapter.inbound.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.study.hexagonal.architecture.application.dto.request.AdviceRequest;
import com.study.hexagonal.architecture.application.port.inbound.rest.AdviceControllerPort;
import com.study.hexagonal.architecture.application.service.AdviceService;

@RestController
@RequiredArgsConstructor
public class AdviceControllerAdapter implements AdviceControllerPort {

    private final AdviceService adviceService;

    public ResponseEntity<Object> importAdvice(@Valid AdviceRequest request) {
        return adviceService.importAdvice(request.getAdviceId());
    }
}
