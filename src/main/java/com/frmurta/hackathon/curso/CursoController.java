package com.frmurta.hackathon.curso;

import com.frmurta.hackathon.abstracoes.AbstractCtrl;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleService;
import com.frmurta.hackathon.example.ExampleServiceImpl;
import com.frmurta.hackathon.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.Control;
import javax.swing.text.html.Option;
import java.lang.reflect.Executable;
import java.util.List;
import java.util.Optional;

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
            return ControllerUtils.sendOk(service.createCurso(curso).getId());
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

    @PutMapping(path = "/publicar/{id}")
    public ResponseEntity publicarCurso(@PathVariable(name = "id")Long id){
        try{
            service.publishCurso(id);
            return ControllerUtils.sendOk(true);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

    @PutMapping(path = "/vestibular/{id}")
    public ResponseEntity vestibularCurso(@PathVariable(name = "id")Long id){
        try{
            service.vestibularCurso(id);
            return ControllerUtils.sendOk(true);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity findByParams(@RequestParam Optional<String> name,
                                       @RequestParam Optional<Long> idFaculdade,
                                       Pageable pageable){

        CursoParams cursoParams = CursoParams.builder()
                .idFaculdade(idFaculdade.isPresent() ? idFaculdade : Optional.empty())
                .name(name.isPresent() ? name : Optional.empty())
                .build();

        try {
            return ControllerUtils.sendOk(service.findByParams(cursoParams, pageable));
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity getAllPublished(){
        try {
            return ControllerUtils.sendOk(service.getAllPublished());
        } catch (Exception e) {
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

}
