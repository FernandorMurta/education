package com.frmurta.hackathon.curso;

import com.frmurta.hackathon.abstracoes.AbstractEntity;
import com.frmurta.hackathon.areaatuacao.AreaAtuacao;
import com.frmurta.hackathon.curso.materiacurso.MateriaCurso;
import com.frmurta.hackathon.faculdade.Faculdade;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table (name = "CURSO")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Curso extends AbstractEntity {

    @NotNull
    private String name;

    private String descricao;

    @NotNull
    @ManyToOne
    private Faculdade faculdade;

    @NotNull
    @ManyToOne
    private AreaAtuacao areaAtuacao;

    private Boolean publicado;

    private Boolean vestibular;

    @OneToMany(mappedBy = "curso")
    private List<MateriaCurso> materiaCursos;


    @Builder
    public Curso(Long id, Boolean ativo, String name, String descricao, Faculdade faculdade, AreaAtuacao areaAtuacao, Boolean publicado, Boolean vestibular){
        super(id, ativo);
        this.name = name;
        this.descricao = descricao;
        this.faculdade = faculdade;
        this.areaAtuacao = areaAtuacao;
        this.publicado = publicado;
        this.vestibular = vestibular;
    }
}
