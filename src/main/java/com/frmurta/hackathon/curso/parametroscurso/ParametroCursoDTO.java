package com.frmurta.hackathon.curso.parametroscurso;

import com.frmurta.hackathon.abstracoes.AbstractDTO;
import com.frmurta.hackathon.curso.Curso;
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
public class ParametroCursoDTO extends AbstractDTO {

    public String bonificacao;

    public Double parametro;
    public Curso curso;

    @Builder
    @QueryProjection
    public ParametroCursoDTO(Long id, Boolean ativo, String bonificacao, BigDecimal parametro) {
        super(id, ativo);
        this.bonificacao = bonificacao;
        this.parametro = parametro.doubleValue();
    }

    public static ConstructorExpression<ParametroCursoDTO> constructorExpression(QParametroCurso parametroCurso) {
        return new QParametroCursoDTO(
                parametroCurso.id,
                parametroCurso.ativo,
                parametroCurso.bonificacao,
                parametroCurso.parametro
        );
    }
}

