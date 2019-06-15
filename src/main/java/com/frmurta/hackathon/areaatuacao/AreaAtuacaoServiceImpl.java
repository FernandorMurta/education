package com.frmurta.hackathon.areaatuacao;

import com.frmurta.hackathon.abstracoes.AbstractService;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepository;
import com.frmurta.hackathon.example.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.geom.Area;
import java.util.List;

@Service
public class AreaAtuacaoServiceImpl extends AbstractService<AreaAtuacao> implements AreaAtuacaoService {

    private final AreaAtuacaoRepository repository;

    @Autowired
    public AreaAtuacaoServiceImpl(AreaAtuacaoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public AreaAtuacao createAreaAtuacao(AreaAtuacao entity){
        return repository.saveAndFlush(entity);
    }

    public List<AreaAtuacaoDTO> listAll(){
        return repository.listAll();
    }
}

