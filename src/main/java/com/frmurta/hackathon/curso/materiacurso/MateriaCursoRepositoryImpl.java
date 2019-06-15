package com.frmurta.hackathon.curso.materiacurso;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepositoryCustom;
import com.frmurta.hackathon.materia.Materia;

public class MateriaCursoRepositoryImpl extends QueryDslSupport implements MateriaCursoRepositoryCustom {

    public MateriaCursoRepositoryImpl() {
        super(MateriaCurso.class);
    }

    public MateriaCurso findByMateriaCurso(Long idCurso, Materia materia) {
        QMateriaCurso materiaCurso = QMateriaCurso.materiaCurso;

        return getQuerydsl().createQuery()
                .select(materiaCurso)
                .from(materiaCurso)
                .where(materiaCurso.materia.id.eq(materia.getId())
                        .and(materiaCurso.curso.id.eq(idCurso)))
                .fetchFirst();
    }
}


