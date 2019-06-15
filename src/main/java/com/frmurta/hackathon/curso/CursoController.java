package com.frmurta.hackathon.curso;

import com.frmurta.hackathon.abstracoes.AbstractCtrl;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleService;
import com.frmurta.hackathon.example.ExampleServiceImpl;
import com.frmurta.hackathon.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.Control;
import java.util.List;

@RestController
@RequestMapping(CursoController.PATH)
public class CursoController extends AbstractCtrl<Curso> {

    public static final String PATH = "api/curso";


    private CursoService service;

    @Autowired
    public CursoController(CursoServiceImpl service) {
        super(service);
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity createCurso(@RequestBody Curso curso){
        try {
            service.createCurso(curso);
            return ControllerUtils.sendOk(true);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

    @GetMapping(path = "/faculdade/{id}")
    public ResponseEntity getAllByFaculdade(@PathVariable(name = "id") Long id){
        try {
            List<CursoDTO>  cursos = service.getAllByFaculdade(id);
            return ControllerUtils.sendOk(cursos);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

}
