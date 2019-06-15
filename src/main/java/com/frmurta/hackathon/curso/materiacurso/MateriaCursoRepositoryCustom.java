package com.frmurta.hackathon.curso.materiacurso;

import com.frmurta.hackathon.materia.Materia;

public interface MateriaCursoRepositoryCustom {

    MateriaCurso findByMateriaCurso(Long idCurso, Materia materia);
}
