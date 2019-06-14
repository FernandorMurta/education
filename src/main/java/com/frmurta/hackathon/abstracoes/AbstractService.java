package com.frmurta.hackathon.abstracoes;


import com.frmurta.hackathon.exception.CustomException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public abstract class AbstractService<T extends AbstractEntity> implements IBaseService<T> {

    private final IBaseRepository<T> repository;

    public AbstractService(IBaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public Optional<T> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional
    public T insert(T entity) throws CustomException {
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void remove(T entity) {
        repository.delete(entity);
    }

    @Override
    @Transactional
    public void removeByID(Long id) {
        repository.deleteById(id);
    }
}
