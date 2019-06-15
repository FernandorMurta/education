package com.frmurta.hackathon.usuario.materiausuario;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;
import com.frmurta.hackathon.curso.materiacurso.MateriaCurso;
import com.frmurta.hackathon.curso.materiacurso.MateriaCursoRepositoryCustom;
import com.frmurta.hackathon.materia.QMateria;

import java.util.List;

public class MateriaUsuarioRepositoryImpl extends QueryDslSupport implements MateriaUsuarioRepositoryCustom {

    public MateriaUsuarioRepositoryImpl() {
        super(MateriaUsuario.class);
    }

    public List<MateriaUsuario> findAllByUsuario(Long idUsuario){
        QMateriaUsuario materiaUsuario = QMateriaUsuario.materiaUsuario;

        return getQuerydsl().createQuery()
                .select(materiaUsuario)
                .from(materiaUsuario)
                .where(materiaUsuario.usuario.id.eq(idUsuario))
                .fetch();
    }
}


