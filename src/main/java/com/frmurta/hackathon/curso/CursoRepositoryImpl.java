package com.frmurta.hackathon.curso;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;
import com.frmurta.hackathon.utils.RepositoryUtils;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;

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

    public Page<CursoDTO> findByParams(CursoParams params, Pageable pageable) {
        QCurso curso = QCurso.curso;

        BooleanBuilder conditions = new BooleanBuilder();

        if (params.getIdFaculdade().isPresent()) {
            long idFaculdade = params.getIdFaculdade().get();
            conditions.and(curso.faculdade.id.eq(idFaculdade));
        }

        if(params.getName().isPresent()){
            String name = params.getName().get();
            conditions.and(curso.name.containsIgnoreCase(name));
        }


        JPQLQuery<CursoDTO> query = Objects.requireNonNull(getQuerydsl())
                .createQuery()
                .select(CursoDTO.constructorExpression(curso))
                .from(curso)
                .where(conditions);

        return readPage((JPAQuery) query, pageable);
    }


}


