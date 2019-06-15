package com.frmurta.hackathon.curso.parametroscurso;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepositoryCustom;

public class ParametroCursoRepositoryImpl extends QueryDslSupport implements ParametroCursoRepositoryCustom {

    public ParametroCursoRepositoryImpl() {
        super(Example.class);
    }
}


