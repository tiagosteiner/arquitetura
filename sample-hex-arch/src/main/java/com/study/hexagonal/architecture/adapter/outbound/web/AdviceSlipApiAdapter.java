package com.study.hexagonal.architecture.adapter.outbound.web;

import com.study.hexagonal.architecture.application.port.outbound.web.AdviceApiPort;
import com.study.hexagonal.architecture.infrastructure.gateway.adviceslip.AdviceSlipClient;
import com.study.hexagonal.architecture.shared.dto.Advice;
import com.study.hexagonal.architecture.shared.exception.AdviceNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdviceSlipApiAdapter implements AdviceApiPort {

    private final AdviceSlipClient adviceSlipClient;
    private final ObjectMapper objectMapper;

    @Override
    public Advice getAdviceById(Integer id) {
        var adviceAsString = adviceSlipClient.getAdviceById(id);
        return deserializeMessage(adviceAsString);
    }

    private Advice deserializeMessage(String adviceStr){
        try {
            return objectMapper.readValue(adviceStr, Advice.class);
        } catch (JsonProcessingException e) {
            throw new AdviceNotFoundException(adviceStr);
        }
    }
}
