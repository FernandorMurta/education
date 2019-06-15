package com.frmurta.hackathon.curso.parametroscurso;

import com.frmurta.hackathon.abstracoes.AbstractEntity;
import com.frmurta.hackathon.curso.Curso;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table (name = "PARAMETRO_CURSO")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ParametroCurso extends AbstractEntity {

    @NotNull
    private String bonificacao;

    @NotNull
    private BigDecimal parametro;

    @NotNull
    @ManyToOne
    private Curso curso;

    @Builder
    public ParametroCurso(Long id, Boolean ativo, String bonificacao, BigDecimal parametro, Curso curso){
        super(id, ativo);
        this.bonificacao = bonificacao;
        this.parametro = parametro;
        this.curso = curso;
    }
}
