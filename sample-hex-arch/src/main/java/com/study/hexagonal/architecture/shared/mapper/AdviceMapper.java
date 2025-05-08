package com.study.hexagonal.architecture.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.study.hexagonal.architecture.adapter.out.entity.JpaAdviceEntity;
import com.study.hexagonal.architecture.domain.entity.Advice;
import com.study.hexagonal.architecture.shared.dto.AdviceDto;

@Mapper(componentModel = "spring")
public interface AdviceMapper {

    AdviceMapper MAPPER = Mappers.getMapper(AdviceMapper.class);

    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "adviceText", source = "adviceText")
    })
    Advice jpaToDomain(JpaAdviceEntity jpaEntity);

    @Mappings({
        @Mapping(target = "id", source = "slip.id"),
        @Mapping(target = "adviceText", source = "slip.advice")
    })
    Advice dtoToEntity(AdviceDto dto);
}
