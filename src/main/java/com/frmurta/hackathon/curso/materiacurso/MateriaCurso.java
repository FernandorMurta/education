package com.frmurta.hackathon.curso.materiacurso;

import com.frmurta.hackathon.abstracoes.AbstractEntity;
import com.frmurta.hackathon.curso.Curso;
import com.frmurta.hackathon.materia.Materia;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table (name = "MATERIA_CURSO")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class MateriaCurso extends AbstractEntity {

    @NotNull
    private BigDecimal peso;
    @NotNull
    @ManyToOne
    private Curso curso;
    @NotNull
    @ManyToOne
    private Materia materia;

    @Builder
    public MateriaCurso(Long id, Boolean ativo, BigDecimal peso, Curso curso, Materia materia){
        super(id, ativo);
        this.peso = peso;
        this.curso = curso;
        this.materia = materia;
    }
}
