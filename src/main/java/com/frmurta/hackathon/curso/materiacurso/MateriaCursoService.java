package com.frmurta.hackathon.curso.materiacurso;

import com.frmurta.hackathon.abstracoes.IBaseService;
import com.frmurta.hackathon.example.Example;

public interface MateriaCursoService extends IBaseService<MateriaCurso> {

    MateriaCurso createMateriaCurso(MateriaCurso materiaCurso);
}
