package com.study.hexagonal.architecture.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.study.hexagonal.architecture.adapter.out.entity.JpaAdviceEntity;
import com.study.hexagonal.architecture.domain.entity.Advice;

@Mapper(componentModel = "spring")
public interface AdviceMapper {
    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "adviceText", source = "adviceText")
    })
    Advice jpaToDomain(JpaAdviceEntity jpaEntity);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "adviceText", source = "adviceText")
    })
    Advice dtoToEntity(JpaAdviceEntity dto);
}
