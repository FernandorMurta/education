package com.frmurta.hackathon.curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CursoRepositoryCustom {

    List<CursoDTO> getAllByFaculdade(Long idFaculdade);

    Page<CursoDTO> findByParams(CursoParams cursoParams, Pageable pageable);

    List<CursoDTO> getAllPublished();
}
