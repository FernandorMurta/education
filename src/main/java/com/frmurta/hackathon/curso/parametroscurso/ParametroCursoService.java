package com.frmurta.hackathon.curso.parametroscurso;

import com.frmurta.hackathon.abstracoes.IBaseService;
import com.frmurta.hackathon.example.Example;

public interface ParametroCursoService extends IBaseService<ParametroCurso> {

    ParametroCurso createParametroCurso(ParametroCurso parametroCurso);

}
