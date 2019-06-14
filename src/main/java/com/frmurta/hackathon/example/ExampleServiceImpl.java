package com.frmurta.hackathon.example;

import com.frmurta.hackathon.abstracoes.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl extends AbstractService<Example> implements ExampleService {

    private final ExampleRepository repository;

    @Autowired
    public ExampleServiceImpl(ExampleRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

