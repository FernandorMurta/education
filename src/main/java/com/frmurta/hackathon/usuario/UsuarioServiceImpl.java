package com.frmurta.hackathon.usuario;

import com.frmurta.hackathon.abstracoes.AbstractService;
import com.frmurta.hackathon.curso.materiacurso.MateriaCurso;
import com.frmurta.hackathon.curso.materiacurso.MateriaCursoRepository;
import com.frmurta.hackathon.exception.CustomException;
import com.frmurta.hackathon.materia.Materia;
import com.frmurta.hackathon.materia.MateriaRepository;
import com.frmurta.hackathon.usuario.materiausuario.MateriaUsuario;
import com.frmurta.hackathon.usuario.materiausuario.MateriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UsuarioServiceImpl extends AbstractService<Usuario> implements UsuarioService {

    private final UsuarioRepository repository;
    private final MateriaRepository materiaRepository;
    private final MateriaUsuarioRepository materiaUsuarioRepository;
    private final MateriaCursoRepository materiaCursoRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository,
                              MateriaRepository materiaRepository,
                              MateriaUsuarioRepository materiaUsuarioRepository,
                              MateriaCursoRepository materiaCursoRepository) {
        super(repository);
        this.repository = repository;
        this.materiaRepository = materiaRepository;
        this.materiaUsuarioRepository = materiaUsuarioRepository;
        this.materiaCursoRepository = materiaCursoRepository;
    }

    public Usuario createUsuario(Usuario entity){
        Usuario usuarioCriado = repository.saveAndFlush(entity);

        List<Materia> materias = materiaRepository.findAll();

        materias.forEach(materia -> {
            MateriaUsuario materiaUsuario = new MateriaUsuario();
            materiaUsuario.setMateria(materia);
            materiaUsuario.setValor(BigDecimal.valueOf(5));
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

    public UsuarioDTO getMedia(Long idUsuario){
        List<MateriaUsuario> materias = materiaUsuarioRepository.findAllByUsuario(idUsuario);
        return new UsuarioDTO(materias);
    }

    public UsuarioDTO getMediaForCurso(Long idCurso, Long idUsuario){
        List<MateriaUsuario> materias = materiaUsuarioRepository.findAllByUsuario(idUsuario);

      Double totalPeso = (double) 0;
      Double totalAluno = (double) 0;

        for (MateriaUsuario materia : materias) {
            MateriaCurso materiaCurso = materiaCursoRepository.findByMateriaCurso(idCurso, materia.getMateria());

            totalPeso += materiaCurso.getPeso().doubleValue();
            BigDecimal total = materiaCurso.getPeso().multiply(materia.getValor());
            totalAluno += total.doubleValue();
        }

        return new UsuarioDTO(totalPeso, totalAluno);
    }
}

