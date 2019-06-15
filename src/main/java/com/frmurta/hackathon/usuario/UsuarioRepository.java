package com.frmurta.hackathon.usuario;

import com.frmurta.hackathon.abstracoes.IBaseRepository;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepositoryCustom;

public interface UsuarioRepository extends IBaseRepository<Usuario>, UsuarioRepositoryCustom {
}
