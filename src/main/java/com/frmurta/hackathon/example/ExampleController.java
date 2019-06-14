package com.frmurta.hackathon.example;

import com.frmurta.hackathon.abstracoes.AbstractCtrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ExampleController.PATH)
public class ExampleController extends AbstractCtrl<Example> {

    public static final String PATH = "api/example";


    private ExampleService service;

    @Autowired
    public ExampleController(ExampleServiceImpl service) {
        super(service);
        this.service = service;
    }

}
