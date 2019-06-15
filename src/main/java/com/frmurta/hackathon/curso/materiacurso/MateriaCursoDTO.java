package com.frmurta.hackathon.curso.materiacurso;

import com.frmurta.hackathon.abstracoes.AbstractDTO;
import com.frmurta.hackathon.example.QExample;
import com.frmurta.hackathon.example.QExampleDTO;
import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.ConstructorExpression;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class MateriaCursoDTO extends AbstractDTO {

    public Double peso;

    @Builder
    @QueryProjection
    public MateriaCursoDTO(Long id, Boolean ativo, BigDecimal peso) {
        super(id, ativo);
        this.peso = peso.doubleValue();
    }

    public static ConstructorExpression<MateriaCursoDTO> constructorExpression(QMateriaCurso materiaCurso) {
        return new QMateriaCursoDTO(
                materiaCurso.id,
                materiaCurso.ativo,
                materiaCurso.peso
        );
    }
}

