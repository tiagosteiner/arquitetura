package com.study.hexagonal.architecture.infrastructure.gateway.adviceslip;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "adviceslip-client", url = "${api.adviceslip.base-url}")
@Component
public interface AdviceSlipClient {

    @GetMapping(value = "/{slip_id}")
    String getAdviceById(@PathVariable("slip_id") Integer slipId);
}
