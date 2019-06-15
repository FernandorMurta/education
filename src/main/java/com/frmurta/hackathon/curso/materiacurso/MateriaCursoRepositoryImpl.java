package com.frmurta.hackathon.curso.materiacurso;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepositoryCustom;

public class MateriaCursoRepositoryImpl extends QueryDslSupport implements MateriaCursoRepositoryCustom {

    public MateriaCursoRepositoryImpl() {
        super(MateriaCurso.class);
    }
}


