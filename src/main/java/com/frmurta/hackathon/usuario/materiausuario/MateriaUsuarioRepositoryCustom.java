package com.frmurta.hackathon.usuario.materiausuario;

import java.util.List;

public interface MateriaUsuarioRepositoryCustom {

    List<MateriaUsuario> findAllByUsuario(Long idUsuario);
}
