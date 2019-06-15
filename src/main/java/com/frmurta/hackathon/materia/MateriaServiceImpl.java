package com.frmurta.hackathon.materia;

import com.frmurta.hackathon.abstracoes.AbstractService;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepository;
import com.frmurta.hackathon.example.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServiceImpl extends AbstractService<Materia> implements MateriaService {

    private final MateriaRepository repository;

    @Autowired
    public MateriaServiceImpl(MateriaRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Materia createMateria(Materia entity){
        return repository.saveAndFlush(entity);
    }

    public List<MateriaDTO> listAll(){
        return repository.listAll();
    }
}

