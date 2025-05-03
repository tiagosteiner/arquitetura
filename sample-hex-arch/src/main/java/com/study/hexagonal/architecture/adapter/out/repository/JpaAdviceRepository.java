package com.study.hexagonal.architecture.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.hexagonal.architecture.adapter.out.entity.JpaAdviceEntity;

@Repository
public interface JpaAdviceRepository extends JpaRepository<JpaAdviceEntity, Integer> {}
