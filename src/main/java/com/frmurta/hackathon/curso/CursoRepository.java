package com.frmurta.hackathon.curso;

import com.frmurta.hackathon.abstracoes.IBaseRepository;
import com.frmurta.hackathon.example.Example;
import com.frmurta.hackathon.example.ExampleRepositoryCustom;

public interface CursoRepository extends IBaseRepository<Curso>, CursoRepositoryCustom {
}
