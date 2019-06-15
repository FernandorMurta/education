package com.frmurta.hackathon.curso;

import com.frmurta.hackathon.abstracoes.IBaseService;
import com.frmurta.hackathon.example.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CursoService extends IBaseService<Curso> {

    Curso createCurso (Curso curso);

    List<CursoDTO> getAllByFaculdade(Long idFaculdade);

    Page<CursoDTO> findByParams(CursoParams cursoParams, Pageable pageable);

    void publishCurso(Long id);

    void vestibularCurso(Long id);

    List<CursoDTO> getAllPublished();

    CursoDTO getById(Long id);
}

