package com.study.hexagonal.architecture.domain.service.impl;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.hexagonal.architecture.domain.entity.Advice;
import com.study.hexagonal.architecture.domain.repository.AdviceRepository;
import com.study.hexagonal.architecture.mock.AdviceDtoMock;

@ExtendWith(MockitoExtension.class)
class AdviceDomainImplServiceTest {

    @Mock private AdviceRepository adviceRepository;

    @InjectMocks private AdviceDomainImplService adviceDomainImplService;

    @Test
    void shouldPersistAdviceWithSuccess() {
        var adviceDtoMock = AdviceDtoMock.createValidAdviceDto();
        // var adviceEntityMock = AdviceMock.createValidAdviceEntity();
        when(adviceRepository.save(any(Advice.class))).thenReturn(any(Advice.class));

        adviceDomainImplService.persistAdvice(adviceDtoMock);

        verify(adviceRepository, times(1)).save(any(Advice.class));
    }
}
