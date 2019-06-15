package com.frmurta.hackathon.usuario.materiausuario;

import com.frmurta.hackathon.abstracoes.AbstractCtrl;
import com.frmurta.hackathon.curso.materiacurso.MateriaCurso;
import com.frmurta.hackathon.curso.materiacurso.MateriaCursoService;
import com.frmurta.hackathon.curso.materiacurso.MateriaCursoServiceImpl;
import com.frmurta.hackathon.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MateriaUsuarioController.PATH)
public class MateriaUsuarioController extends AbstractCtrl<MateriaUsuario> {

    public static final String PATH = "api/materia-usuario";


    private MateriaUsuarioService service;

    @Autowired
    public MateriaUsuarioController(MateriaUsuarioServiceImpl service) {
        super(service);
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity createMateriaUsuario(@RequestBody MateriaUsuario materiaUsuario){
        try{
            service.createMateriaUsuario(materiaUsuario);
            return ControllerUtils.sendOk(true);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }
}
