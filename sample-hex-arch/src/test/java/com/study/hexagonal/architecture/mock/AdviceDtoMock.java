package com.study.hexagonal.architecture.mock;

import com.study.hexagonal.architecture.shared.dto.AdviceDto;
import com.study.hexagonal.architecture.shared.dto.AdviceSlipDto;

public class AdviceDtoMock {
    public static AdviceDto createValidAdviceDto() {
        var adviceSlipDto =
                new AdviceSlipDto(1, "Remember that spiders are more afraid of you, than you are of them.");
        var adviceDto = new AdviceDto();
        adviceDto.setSlip(adviceSlipDto);
        return adviceDto;
    }
}
