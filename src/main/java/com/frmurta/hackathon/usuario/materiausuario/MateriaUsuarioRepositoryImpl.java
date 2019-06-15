package com.frmurta.hackathon.usuario.materiausuario;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;
import com.frmurta.hackathon.curso.materiacurso.MateriaCurso;
import com.frmurta.hackathon.curso.materiacurso.MateriaCursoRepositoryCustom;

public class MateriaUsuarioRepositoryImpl extends QueryDslSupport implements MateriaUsuarioRepositoryCustom {

    public MateriaUsuarioRepositoryImpl() {
        super(MateriaUsuario.class);
    }
}


