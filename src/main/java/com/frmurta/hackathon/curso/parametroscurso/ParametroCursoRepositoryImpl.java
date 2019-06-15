package com.frmurta.hackathon.curso.parametroscurso;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepositoryCustom;

import java.util.List;

public class ParametroCursoRepositoryImpl extends QueryDslSupport implements ParametroCursoRepositoryCustom {

    public ParametroCursoRepositoryImpl() {
        super(Example.class);
    }

    public List<ParametroCurso> findAllByCurso(Long idCurso){
        QParametroCurso parametroCurso = QParametroCurso.parametroCurso;

        return getQuerydsl().createQuery()
                .select(parametroCurso)
                .from(parametroCurso)
                .where(parametroCurso.curso.id.eq(idCurso))
                .fetch();
    }
}


