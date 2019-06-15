package com.frmurta.hackathon.curso.parametroscurso;

import com.frmurta.hackathon.abstracoes.AbstractService;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepository;
import com.frmurta.hackathon.example.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParametroCursoServiceImpl extends AbstractService<ParametroCurso> implements ParametroCursoService {

    private final ParametroCursoRepository repository;

    @Autowired
    public ParametroCursoServiceImpl(ParametroCursoRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

