package com.frmurta.hackathon.curso.parametroscurso;

import com.frmurta.hackathon.abstracoes.IBaseService;
import com.frmurta.hackathon.example.Example;
import com.querydsl.core.types.dsl.Param;

import java.util.List;

public interface ParametroCursoService extends IBaseService<ParametroCurso> {

    ParametroCurso createParametroCurso(ParametroCurso parametroCurso);

    void createAllParametroCurso(List<ParametroCurso> parametros, Long idCurso);

}
