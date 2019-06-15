package com.frmurta.hackathon.materia;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepositoryCustom;

import java.util.List;

public class MateriaRepositoryImpl extends QueryDslSupport implements MateriaRepositoryCustom {

    public MateriaRepositoryImpl() {
        super(Materia.class);
    }


    public List<MateriaDTO> listAll(){
        QMateria materia = QMateria.materia;

        return getQuerydsl().createQuery()
                .select(MateriaDTO.constructorExpression(materia))
                .from(materia)
                .where(materia.ativo.isTrue())
                .fetch();
    }
}


