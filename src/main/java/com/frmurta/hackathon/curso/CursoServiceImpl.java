package com.frmurta.hackathon.curso;

import com.frmurta.hackathon.abstracoes.AbstractService;
import com.frmurta.hackathon.curso.materiacurso.MateriaCursoRepository;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepository;
import com.frmurta.hackathon.example.ExampleService;
import com.frmurta.hackathon.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

        cursoParaPublicar.setPublicado(!cursoParaPublicar.getPublicado());
        repository.save(cursoParaPublicar);
    }

    public void vestibularCurso(Long id){
        Curso cursoParaVestibular = repository.getOne(id);

        if(cursoParaVestibular == null){
            throw new CustomException("Curso nao encontrado");
        }

        cursoParaVestibular.setVestibular(!cursoParaVestibular.getVestibular());
        repository.save(cursoParaVestibular);
    }

    public Page<CursoDTO> findByParams(CursoParams cursoParams, Pageable pageable){
        return repository.findByParams(cursoParams, pageable);
    }
}

