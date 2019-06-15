package com.frmurta.hackathon.curso.parametroscurso;

import com.frmurta.hackathon.abstracoes.AbstractCtrl;
import com.frmurta.hackathon.curso.materiacurso.MateriaCurso;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleService;
import com.frmurta.hackathon.example.ExampleServiceImpl;
import com.frmurta.hackathon.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ParametroCursoController.PATH)
public class ParametroCursoController extends AbstractCtrl<ParametroCurso> {

    public static final String PATH = "api/parametro-curso";


    private ParametroCursoService service;

    @Autowired
    public ParametroCursoController(ParametroCursoServiceImpl service) {
        super(service);
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity createParametroCurso(@RequestBody ParametroCurso parametroCurso){
        try{
            service.createParametroCurso(parametroCurso);
            return ControllerUtils.sendOk(true);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

    @PostMapping(path = "/create-all/{id}")
    public ResponseEntity createAllParametro(@RequestBody List<ParametroCurso> parametros,
                                             @PathVariable(name = "id") Long id){
        try {
            service.createAllParametroCurso(parametros, id);
            return ControllerUtils.sendOk(true);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }
}
