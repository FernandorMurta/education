package com.frmurta.hackathon.materia;

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
public class MateriaDTO extends AbstractDTO {

    public String name;

    @Builder
    @QueryProjection
    public MateriaDTO(Long id, Boolean ativo, String name) {
        super(id, ativo);
        this.name = name;
    }

    public static ConstructorExpression<MateriaDTO> constructorExpression(QMateria materia) {
        return new QMateriaDTO(
                materia.id,
                materia.ativo,
                materia.name
        );
    }
}

