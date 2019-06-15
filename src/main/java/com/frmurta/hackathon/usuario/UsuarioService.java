package com.frmurta.hackathon.usuario;

import com.frmurta.hackathon.abstracoes.IBaseService;
import com.frmurta.hackathon.example.Example;

public interface UsuarioService extends IBaseService<Usuario> {

    Usuario createUsuario(Usuario usuario);

    Usuario makeLogin(Usuario usuario);

}
