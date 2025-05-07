package com.study.hexagonal.architecture.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.hexagonal.architecture.domain.entity.Advice;
import com.study.hexagonal.architecture.domain.repository.AdviceRepository;
import com.study.hexagonal.architecture.mock.AdviceDtoMock;
import com.study.hexagonal.architecture.mock.AdviceMock;
import com.study.hexagonal.architecture.shared.dto.AdviceDto;
import com.study.hexagonal.architecture.shared.dto.AdviceSlipDto;
import com.study.hexagonal.architecture.shared.mapper.AdviceMapper;

@ExtendWith(MockitoExtension.class)
class AdviceDomainImplServiceTest {

    @Mock private AdviceRepository adviceRepository;
    @Mock private AdviceMapper adviceMapper;

    @InjectMocks private AdviceDomainImplService adviceDomainImplService;

    @Test
    void shouldPersistAdviceWithSuccess_AllArgsConstructor() {
        var adviceDtoMock = AdviceDtoMock.createValidAdviceDto();
        var adviceEntityMock = AdviceMock.createValidAdviceEntity();
        when(adviceMapper.dtoToEntity(adviceDtoMock)).thenReturn(adviceEntityMock);
        when(adviceRepository.save(adviceEntityMock)).thenReturn(any(Advice.class));

        adviceDomainImplService.persistAdvice(adviceDtoMock);

        verify(adviceRepository, times(1)).save(adviceEntityMock);
    }

    @Test
    void shouldPersistAdviceWithSuccess_NoArgsConstructor() {
        var slip =
                new AdviceSlipDto(1, "Remember that spiders are more afraid of you, than you are of them.");
        var adviceDtoMock = new AdviceDto();
        adviceDtoMock.setSlip(slip);

        Advice adviceEntityMock = new Advice();
        adviceEntityMock.setAdviceText(
                "Remember that spiders are more afraid of you, than you are of them.");
        adviceEntityMock.setId(1);

        when(adviceMapper.dtoToEntity(adviceDtoMock)).thenReturn(adviceEntityMock);
        when(adviceRepository.save(adviceEntityMock)).thenReturn(any(Advice.class));

        adviceDomainImplService.persistAdvice(adviceDtoMock);

        verify(adviceRepository, times(1)).save(adviceEntityMock);
        assertEquals(1, adviceEntityMock.getId());
        assertEquals(
                "Remember that spiders are more afraid of you, than you are of them.",
                adviceEntityMock.getAdviceText());
    }
}
