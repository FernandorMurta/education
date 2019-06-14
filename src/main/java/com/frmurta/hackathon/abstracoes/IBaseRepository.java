package com.frmurta.hackathon.abstracoes;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface IBaseRepository<T extends AbstractEntity> extends QuerydslPredicateExecutor<T>, JpaRepository<T, Long> {
}
