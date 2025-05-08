package com.study.hexagonal.architecture.shared.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.hexagonal.architecture.mock.AdviceDtoMock;
import com.study.hexagonal.architecture.shared.dto.AdviceDto;
import com.study.hexagonal.architecture.shared.dto.AdviceSlipDto;

@ExtendWith(MockitoExtension.class)
class AdviceMapperTest {

    @Test
    void testMapDtoToEntityWithData() {
        AdviceDto dto = AdviceDtoMock.createValidAdviceDto();

        var entity = AdviceMapper.MAPPER.dtoToEntity(dto);

        assertEquals(
                "Remember that spiders are more afraid of you, than you are of them.",
                entity.getAdviceText());
        assertEquals(1, entity.getId());
    }

    @Test
    void testMapDtoToEntityNullObject() {
        var entity = AdviceMapper.MAPPER.dtoToEntity(null);
        assertNull(entity);
    }

    @Test
    void testMapDtoToEntitySlipDtoIdNullObject() {
        var informedSlipDto = new AdviceSlipDto(null, "lalala");
        var informed = new AdviceDto();
        informed.setSlip(informedSlipDto);

        var entity = AdviceMapper.MAPPER.dtoToEntity(informed);

        assertEquals(informedSlipDto.getId(), entity.getId());
        assertEquals(informedSlipDto.getAdvice(), entity.getAdviceText());
    }

    @Test
    void testMapDtoToEntitySlipDtoAdviceNullObject() {
        var informedSlipDto = new AdviceSlipDto(1, null);
        var informed = new AdviceDto();
        informed.setSlip(informedSlipDto);

        var entity = AdviceMapper.MAPPER.dtoToEntity(informed);

        assertEquals(informedSlipDto.getId(), entity.getId());
        assertEquals(informedSlipDto.getAdvice(), entity.getAdviceText());
    }
}
