package com.frmurta.hackathon.areaatuacao;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepositoryCustom;

import java.util.List;

public class AreaAtuacaoRepositoryImpl extends QueryDslSupport implements AreaAtuacaoRepositoryCustom {

    public AreaAtuacaoRepositoryImpl() {
        super(AreaAtuacao.class);
    }

    public List<AreaAtuacaoDTO> listAll(){
        QAreaAtuacao areaAtuacao = QAreaAtuacao.areaAtuacao;

        return getQuerydsl().createQuery()
                .select(AreaAtuacaoDTO.constructorExpression(areaAtuacao))
                .from(areaAtuacao)
                .where(areaAtuacao.ativo.isTrue())
                .fetch();
    }
}


