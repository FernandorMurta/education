package com.frmurta.hackathon.areaatuacao;

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
@RequestMapping(AreaAtuacaoController.PATH)
public class AreaAtuacaoController extends AbstractCtrl<AreaAtuacao> {

    public static final String PATH = "api/area-atuacao";


    private AreaAtuacaoService service;

    @Autowired
    public AreaAtuacaoController(AreaAtuacaoServiceImpl service) {
        super(service);
        this.service = service;
    }


    @PostMapping(path = "/create")
    public ResponseEntity createAreaAtuacao(@RequestBody AreaAtuacao areaAtuacao){
        try {
            service.createAreaAtuacao(areaAtuacao);
            return ControllerUtils.sendOk(true);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity listAll(){
        try {
            List<AreaAtuacaoDTO> areas = service.listAll();
            return ControllerUtils.sendOk(areas);
        } catch (Exception e){
            return ControllerUtils.sendBadRequest(e.getMessage());
        }
    }

}
