package com.frmurta.hackathon.curso;

import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class CursoParams {

    private Optional<String> name;
    private Optional<Long> idFaculdade;
}
