package com.frmurta.hackathon.curso.parametroscurso;

import com.frmurta.hackathon.abstracoes.AbstractService;
import com.frmurta.hackathon.curso.Curso;
import com.frmurta.hackathon.curso.CursoRepository;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepository;
import com.frmurta.hackathon.example.ExampleService;
import com.querydsl.core.types.dsl.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametroCursoServiceImpl extends AbstractService<ParametroCurso> implements ParametroCursoService {

    private final ParametroCursoRepository repository;
    private final CursoRepository cursoRepository;

    @Autowired
    public ParametroCursoServiceImpl(ParametroCursoRepository repository,
                                     CursoRepository cursoRepository) {
        super(repository);
        this.repository = repository;
        this.cursoRepository = cursoRepository;
    }

    public ParametroCurso createParametroCurso(ParametroCurso parametroCurso){
        return repository.saveAndFlush(parametroCurso);
    }

    public void createAllParametroCurso(List<ParametroCurso> parametros, Long idCurso){
        Curso curso = cursoRepository.getOne(idCurso);

        parametros.forEach(parametroCurso -> {
            parametroCurso.setCurso(curso);
            repository.save(parametroCurso);
        });
    }
}

