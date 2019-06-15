package com.frmurta.hackathon.curso.parametroscurso;

import java.util.List;

public interface ParametroCursoRepositoryCustom {

    List<ParametroCurso> findAllByCurso(Long idCurso);
}
