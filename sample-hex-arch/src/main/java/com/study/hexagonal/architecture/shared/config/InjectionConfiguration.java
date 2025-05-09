package com.study.hexagonal.architecture.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.study.hexagonal.architecture.application.port.in.usecase.AdviceUseCases;
import com.study.hexagonal.architecture.application.port.out.rest.AdviceApi;
import com.study.hexagonal.architecture.application.service.AdviceUseCasesImpl;
import com.study.hexagonal.architecture.domain.repository.AdviceRepository;
import com.study.hexagonal.architecture.domain.service.AdviceDomainService;
import com.study.hexagonal.architecture.domain.service.impl.AdviceDomainImplService;
import com.study.hexagonal.architecture.shared.mapper.AdviceMapper;

@Configuration
public class InjectionConfiguration {

    @Bean
    public AdviceDomainService createAdviceDomainServicePort(
            AdviceRepository adviceRepositoryPort, AdviceMapper adviceMapperPort) {
        return new AdviceDomainImplService(adviceRepositoryPort, adviceMapperPort);
    }

    @Bean
    public AdviceUseCases createAdviceUseCasesPort(
            AdviceApi adviceApiPort, AdviceDomainService adviceDomainServicePort) {
        return new AdviceUseCasesImpl(adviceApiPort, adviceDomainServicePort);
    }
}
