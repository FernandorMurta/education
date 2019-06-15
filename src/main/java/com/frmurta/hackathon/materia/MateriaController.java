package com.frmurta.hackathon.materia;

import com.frmurta.hackathon.abstracoes.AbstractCtrl;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleService;
import com.frmurta.hackathon.example.ExampleServiceImpl;
import com.frmurta.hackathon.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(MateriaController.PATH)
public class MateriaController extends AbstractCtrl<Materia> {

    public static final String PATH = "api/materia";


    private MateriaService service;

    @Autowired
    public MateriaController(MateriaServiceImpl service) {
        super(service);
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity createMateria(@RequestBody Materia materia){
        try {
            service.createMateria(materia);
            return ControllerUtils.sendOk(true);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity listAll(){
        try {
            List<MateriaDTO> materias = service.listAll();
            return ControllerUtils.sendOk(materias);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

}
