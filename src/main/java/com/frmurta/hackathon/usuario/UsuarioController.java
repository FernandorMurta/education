package com.frmurta.hackathon.usuario;

import com.frmurta.hackathon.abstracoes.AbstractCtrl;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleService;
import com.frmurta.hackathon.example.ExampleServiceImpl;
import com.frmurta.hackathon.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UsuarioController.PATH)
public class UsuarioController extends AbstractCtrl<Usuario> {

    public static final String PATH = "api/usuario";


    private UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioServiceImpl service) {
        super(service);
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity createUsuario(@RequestBody Usuario usuario){
        try {
            service.createUsuario(usuario);
            return ControllerUtils.sendOk(usuario);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }


    @PostMapping(path ="/login")
    public ResponseEntity makeLogin(@RequestBody Usuario usuario){
        try {
            return ControllerUtils.sendOk(service.makeLogin(usuario));
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

    @GetMapping(path = "/media/{id}")
    public ResponseEntity getMedia(@PathVariable(name = "id") Long id){
        try {
            return ControllerUtils.sendOk(service.getMedia(id));
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

    @GetMapping(path = "media/{idCurso}/{idUsuario}")
    public ResponseEntity getMediaForCurso(@PathVariable(name = "idCurso") Long idCurso,
                                           @PathVariable(name = "idUsuario") Long idUsuario){
        try {
            return ControllerUtils.sendOk(service.getMediaForCurso(idCurso, idUsuario));
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }
}
