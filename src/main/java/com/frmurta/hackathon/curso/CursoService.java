package com.frmurta.hackathon.curso;

import com.frmurta.hackathon.abstracoes.IBaseService;
import com.frmurta.hackathon.example.Example;

import java.util.List;

public interface CursoService extends IBaseService<Curso> {

    Curso createCurso (Curso curso);

    List<CursoDTO> getAllByFaculdade(Long idFaculdade);
}
