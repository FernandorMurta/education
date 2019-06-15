package com.frmurta.hackathon.faculdade;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepositoryCustom;

public class FaculdadeRepositoryImpl extends QueryDslSupport implements FaculdadeRepositoryCustom {

    public FaculdadeRepositoryImpl() {
        super(Faculdade.class);
    }


    public Faculdade makeLogin(Faculdade entity) {
        QFaculdade faculdade = QFaculdade.faculdade;

        return getQuerydsl().createQuery()
                .select(faculdade)
                .from(faculdade)
                .where(faculdade.email.eq(entity.getEmail())
                        .and(faculdade.password.eq(entity.getPassword())))
                .fetchFirst();
    }
}


