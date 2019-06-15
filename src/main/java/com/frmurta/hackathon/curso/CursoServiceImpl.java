package com.frmurta.hackathon.curso;

import com.frmurta.hackathon.abstracoes.AbstractService;
import com.frmurta.hackathon.curso.materiacurso.MateriaCursoRepository;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepository;
import com.frmurta.hackathon.example.ExampleService;
import com.frmurta.hackathon.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl extends AbstractService<Curso> implements CursoService {

    private final CursoRepository repository;
    private final MateriaCursoRepository materiaCursoRepository;

    @Autowired
    public CursoServiceImpl(CursoRepository repository,
                            MateriaCursoRepository materiaCursoRepository) {
        super(repository);
        this.repository = repository;
        this.materiaCursoRepository = materiaCursoRepository;
    }

    public Curso createCurso(Curso entity){

        entity.setPublicado(false);
        Curso curso = repository.saveAndFlush(entity);

        entity.getMateriaCursos().forEach(materiaCurso -> {
            materiaCurso.setCurso(curso);
            materiaCursoRepository.save(materiaCurso);
        });

        return curso;
    }

    public List<CursoDTO> getAllByFaculdade(Long idFaculdade){
        return repository.getAllByFaculdade(idFaculdade);
    }

    public void publishCurso(Long id){
        Curso cursoParaPublicar = repository.getOne(id);

        if(cursoParaPublicar == null){
            throw new CustomException("Curso nao encontrado");
        }

        cursoParaPublicar.setPublicado(true);
        repository.save(cursoParaPublicar);
    }
}

