package com.study.hexagonal.architecture.adapter.inbound.rest;

import com.study.hexagonal.architecture.application.dto.request.AdviceRequest;
import com.study.hexagonal.architecture.application.port.inbound.rest.AdviceControllerPort;
import com.study.hexagonal.architecture.application.service.AdviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdviceControllerAdapter implements AdviceControllerPort {

    private final AdviceService adviceService;

    public ResponseEntity<Object> importAdvice(@RequestBody AdviceRequest request) {
        return adviceService.importAdvice(request.adviceId());
    }

}
