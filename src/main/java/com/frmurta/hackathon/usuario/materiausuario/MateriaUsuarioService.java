package com.frmurta.hackathon.usuario.materiausuario;

import com.frmurta.hackathon.abstracoes.IBaseService;
import com.frmurta.hackathon.curso.materiacurso.MateriaCurso;

public interface MateriaUsuarioService extends IBaseService<MateriaUsuario> {

    MateriaUsuario createMateriaUsuario(MateriaUsuario materiaUsuario);
}
