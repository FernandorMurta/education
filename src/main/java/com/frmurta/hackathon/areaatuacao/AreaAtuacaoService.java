package com.frmurta.hackathon.areaatuacao;

import com.frmurta.hackathon.abstracoes.IBaseService;
import com.frmurta.hackathon.example.Example;

import java.awt.*;
import java.awt.geom.Area;
import java.util.List;

public interface AreaAtuacaoService extends IBaseService<AreaAtuacao> {

    AreaAtuacao createAreaAtuacao(AreaAtuacao areaAtuacao);

    List<AreaAtuacaoDTO> listAll();
}
