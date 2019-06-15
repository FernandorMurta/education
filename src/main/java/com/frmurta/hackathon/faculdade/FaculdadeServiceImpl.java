package com.frmurta.hackathon.faculdade;

import com.frmurta.hackathon.abstracoes.AbstractService;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepository;
import com.frmurta.hackathon.example.ExampleService;
import com.frmurta.hackathon.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaculdadeServiceImpl extends AbstractService<Faculdade> implements FaculdadeService {

    private final FaculdadeRepository repository;

    @Autowired
    public FaculdadeServiceImpl(FaculdadeRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Faculdade createFaculdade(Faculdade entity){

        return repository.saveAndFlush(entity);
    }

    public Faculdade makeLogin(Faculdade entity){
        Faculdade faculdadeLogada = repository.makeLogin(entity);

        if(faculdadeLogada == null){
            throw new CustomException("Usuario nao encontrado");
        }

        return faculdadeLogada;
    }
}

