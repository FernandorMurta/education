package com.frmurta.hackathon.curso.parametroscurso;

import com.frmurta.hackathon.abstracoes.AbstractCtrl;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleService;
import com.frmurta.hackathon.example.ExampleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
