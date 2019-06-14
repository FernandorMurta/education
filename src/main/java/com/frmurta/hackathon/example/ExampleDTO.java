package com.frmurta.hackathon.example;

import com.frmurta.hackathon.abstracoes.AbstractDTO;
import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.ConstructorExpression;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ExampleDTO extends AbstractDTO {

    private String name;

    @Builder
    @QueryProjection
    public ExampleDTO(Long id, Boolean ativo, String name) {
        super(id, ativo);
        this.name = name;
    }

    public static ConstructorExpression<ExampleDTO> constructorExpression(QExample example) {
        return new QExampleDTO(
                example.id,
                example.ativo,
                example.name
        );
    }
}

