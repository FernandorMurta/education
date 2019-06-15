package com.frmurta.hackathon.curso;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepositoryCustom;

import java.util.List;

public class CursoRepositoryImpl extends QueryDslSupport implements CursoRepositoryCustom {

    public CursoRepositoryImpl() {
        super(Curso.class);
    }

    public List<CursoDTO> getAllByFaculdade(Long idFaculdade) {
        QCurso curso = QCurso.curso;

        return getQuerydsl().createQuery()
                .select(CursoDTO.constructorExpression(curso))
                .from(curso)
                .where(curso.ativo.isTrue()
                        .and(curso.faculdade.id.eq(idFaculdade)))
                .fetch();
    }
}


