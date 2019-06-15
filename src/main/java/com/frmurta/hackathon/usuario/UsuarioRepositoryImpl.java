package com.frmurta.hackathon.usuario;

import com.frmurta.hackathon.abstracoes.QueryDslSupport;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepositoryCustom;

public class UsuarioRepositoryImpl extends QueryDslSupport implements UsuarioRepositoryCustom {

    public UsuarioRepositoryImpl() {
        super(Usuario.class);
    }

    public Usuario makeLogin(Usuario entity) {
        QUsuario usuario = QUsuario.usuario;

        return getQuerydsl().createQuery()
                .select(usuario)
                .from(usuario)
                .where(usuario.email.eq(entity.getEmail())
                        .and(usuario.password.eq(entity.getPassword())))
                .fetchFirst();
    }
}


