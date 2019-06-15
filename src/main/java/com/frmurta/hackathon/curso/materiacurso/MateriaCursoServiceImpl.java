package com.frmurta.hackathon.curso.materiacurso;

import com.frmurta.hackathon.abstracoes.AbstractService;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepository;
import com.frmurta.hackathon.example.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaCursoServiceImpl extends AbstractService<MateriaCurso> implements MateriaCursoService {

    private final MateriaCursoRepository repository;

    @Autowired
    public MateriaCursoServiceImpl(MateriaCursoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public MateriaCurso createMateriaCurso(MateriaCurso entity){
        return repository.saveAndFlush(entity);
    }
}

