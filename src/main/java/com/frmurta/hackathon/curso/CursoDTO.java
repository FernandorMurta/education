package com.frmurta.hackathon.curso;

import com.frmurta.hackathon.abstracoes.AbstractDTO;
import com.frmurta.hackathon.areaatuacao.AreaAtuacao;
import com.frmurta.hackathon.areaatuacao.AreaAtuacaoDTO;
import com.frmurta.hackathon.example.QExample;
import com.frmurta.hackathon.example.QExampleDTO;
import com.frmurta.hackathon.faculdade.Faculdade;
import com.frmurta.hackathon.faculdade.FaculdadeDTO;
import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.ConstructorExpression;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class CursoDTO extends AbstractDTO {

    public  String name;
    public Faculdade faculdade;
    public FaculdadeDTO faculdadeDTO;
    public AreaAtuacao areaAtuacao;
    public AreaAtuacaoDTO areaAtuacaoDTO;

    @Builder
    @QueryProjection
    public CursoDTO(Long id, Boolean ativo, String name) {
        super(id, ativo);
        this.name = name;
    }

    public static ConstructorExpression<CursoDTO> constructorExpression(QCurso curso) {
        return new QCursoDTO(
                curso.id,
                curso.ativo,
                curso.name
        );
    }
}
