package com.frmurta.hackathon.faculdade;

import com.frmurta.hackathon.abstracoes.AbstractCtrl;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleService;
import com.frmurta.hackathon.example.ExampleServiceImpl;
import com.frmurta.hackathon.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(FaculdadeController.PATH)
public class FaculdadeController extends AbstractCtrl<Faculdade> {

    public static final String PATH = "api/faculdade";


    private FaculdadeService service;

    @Autowired
    public FaculdadeController(FaculdadeServiceImpl service) {
        super(service);
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity createFaculdade(@RequestBody Faculdade faculdade){
        try {
            service.createFaculdade(faculdade);
            return ControllerUtils.sendOk(true);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity makeLogin(@RequestBody Faculdade faculdade){
        try {
            return ControllerUtils.sendOk(service.makeLogin(faculdade));
        } catch (Exception e){
            return ControllerUtils.sendBadRequest("Usuario ou Senha Incorreto");
        }
    }
}
