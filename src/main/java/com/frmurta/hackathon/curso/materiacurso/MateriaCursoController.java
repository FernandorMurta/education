package com.frmurta.hackathon.curso.materiacurso;

import com.frmurta.hackathon.abstracoes.AbstractCtrl;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleService;
import com.frmurta.hackathon.example.ExampleServiceImpl;
import com.frmurta.hackathon.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MateriaCursoController.PATH)
public class MateriaCursoController extends AbstractCtrl<MateriaCurso> {

    public static final String PATH = "api/materia-curso";


    private MateriaCursoService service;

    @Autowired
    public MateriaCursoController(MateriaCursoServiceImpl service) {
        super(service);
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity createMateriaCurso(@RequestBody MateriaCurso materiaCurso){
        try{
            service.createMateriaCurso(materiaCurso);
            return ControllerUtils.sendOk(true);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }
}
