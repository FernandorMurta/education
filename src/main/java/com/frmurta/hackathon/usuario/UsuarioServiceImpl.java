package com.frmurta.hackathon.usuario;

import com.frmurta.hackathon.abstracoes.AbstractService;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepository;
import com.frmurta.hackathon.example.ExampleService;
import com.frmurta.hackathon.exception.CustomException;
import com.frmurta.hackathon.materia.Materia;
import com.frmurta.hackathon.materia.MateriaRepository;
import com.frmurta.hackathon.usuario.materiausuario.MateriaUsuario;
import com.frmurta.hackathon.usuario.materiausuario.MateriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UsuarioServiceImpl extends AbstractService<Usuario> implements UsuarioService {

    private final UsuarioRepository repository;
    private final MateriaRepository materiaRepository;
    private final MateriaUsuarioRepository materiaUsuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository,
                              MateriaRepository materiaRepository,
                              MateriaUsuarioRepository materiaUsuarioRepository) {
        super(repository);
        this.repository = repository;
        this.materiaRepository = materiaRepository;
        this.materiaUsuarioRepository = materiaUsuarioRepository;
    }

    public Usuario createUsuario(Usuario entity){
        Usuario usuarioCriado = repository.saveAndFlush(entity);

        List<Materia> materias = materiaRepository.findAll();

        materias.forEach(materia -> {
            MateriaUsuario materiaUsuario = new MateriaUsuario();
            materiaUsuario.setMateria(materia);
            materiaUsuario.setPeso(BigDecimal.valueOf(5));
            materiaUsuario.setUsuario(usuarioCriado);
            materiaUsuarioRepository.save(materiaUsuario);
        });

        return usuarioCriado;
    }

    public Usuario makeLogin(Usuario entity){
        Usuario usuarioLogado = repository.makeLogin(entity);

        if(usuarioLogado == null){
            throw new CustomException("Usuario nao encontrado");
        }
        return usuarioLogado;
    }
}

