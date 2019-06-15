package com.frmurta.hackathon.materia;

import com.frmurta.hackathon.abstracoes.IBaseService;
import com.frmurta.hackathon.example.Example;

import java.util.List;

public interface MateriaService extends IBaseService<Materia> {

    Materia createMateria(Materia materia);

    List<MateriaDTO> listAll();
}
