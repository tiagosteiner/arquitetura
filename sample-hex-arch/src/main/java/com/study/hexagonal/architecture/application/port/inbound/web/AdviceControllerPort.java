package com.study.hexagonal.architecture.application.port.inbound.web;

import com.study.hexagonal.architecture.application.dto.request.AdviceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/v1/free-advice")
public interface AdviceControllerPort {

    @PostMapping("/import")
    ResponseEntity<Object> importAdvice(@RequestBody AdviceRequest request);
}
