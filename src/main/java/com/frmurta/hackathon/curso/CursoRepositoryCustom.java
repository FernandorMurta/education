package com.frmurta.hackathon.curso;

import java.util.List;

public interface CursoRepositoryCustom {

    List<CursoDTO> getAllByFaculdade(Long idFaculdade);
}
