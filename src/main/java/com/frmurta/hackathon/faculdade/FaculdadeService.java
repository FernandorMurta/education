package com.frmurta.hackathon.faculdade;

import com.frmurta.hackathon.abstracoes.IBaseService;
import com.frmurta.hackathon.example.Example;

public interface FaculdadeService extends IBaseService<Faculdade> {

    Faculdade createFaculdade(Faculdade faculdade);

    Faculdade makeLogin(Faculdade faculdade);
}
