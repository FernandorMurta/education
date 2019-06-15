package com.frmurta.hackathon.usuario.materiausuario;

import com.frmurta.hackathon.abstracoes.AbstractService;
import com.frmurta.hackathon.curso.materiacurso.MateriaCurso;
import com.frmurta.hackathon.curso.materiacurso.MateriaCursoRepository;
import com.frmurta.hackathon.curso.materiacurso.MateriaCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaUsuarioServiceImpl extends AbstractService<MateriaUsuario> implements MateriaUsuarioService {

    private final MateriaUsuarioRepository repository;

    @Autowired
    public MateriaUsuarioServiceImpl(MateriaUsuarioRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public MateriaUsuario createMateriaUsuario(MateriaUsuario entity){
        return repository.saveAndFlush(entity);
    }
}

