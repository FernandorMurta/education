package com.frmurta.hackathon.example;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;

public class ExampleRepositoryImpl extends QueryDslSupport implements ExampleRepositoryCustom {

    public ExampleRepositoryImpl() {
        super(Example.class);
    }
}


