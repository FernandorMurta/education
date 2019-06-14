package com.frmurta.hackathon.abstracoes;

import com.frmurta.hackathon.exception.CustomException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBaseService<T> {

    Page<T> findAll(Pageable pageable);

    Optional<T> findOne(Long id);

    T insert(T entity) throws CustomException;

    T update(T entity);

    void remove(T entity);

    void removeByID(Long id);
}
