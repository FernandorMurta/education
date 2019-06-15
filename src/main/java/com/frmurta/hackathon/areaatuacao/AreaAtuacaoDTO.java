package com.frmurta.hackathon.areaatuacao;

import com.frmurta.hackathon.abstracoes.AbstractDTO;
import com.frmurta.hackathon.example.QExample;
import com.frmurta.hackathon.example.QExampleDTO;
import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.ConstructorExpression;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class AreaAtuacaoDTO extends AbstractDTO {

    private String name;

    @Builder
    @QueryProjection
    public AreaAtuacaoDTO(Long id, Boolean ativo, String name) {
        super(id, ativo);
        this.name = name;
    }

    public static ConstructorExpression<AreaAtuacaoDTO> constructorExpression(QAreaAtuacao areaAtuacao) {
        return new QAreaAtuacaoDTO(
                areaAtuacao.id,
                areaAtuacao.ativo,
                areaAtuacao.name
        );
    }
}

