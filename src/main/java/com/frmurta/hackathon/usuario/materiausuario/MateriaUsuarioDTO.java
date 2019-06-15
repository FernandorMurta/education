package com.frmurta.hackathon.usuario.materiausuario;

import com.frmurta.hackathon.abstracoes.AbstractDTO;
import com.frmurta.hackathon.curso.materiacurso.QMateriaCurso;
import com.frmurta.hackathon.curso.materiacurso.QMateriaCursoDTO;
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
public class MateriaUsuarioDTO extends AbstractDTO {

    public Double valor;

    @Builder
    @QueryProjection
    public MateriaUsuarioDTO(Long id, Boolean ativo, BigDecimal valor) {
        super(id, ativo);
        this.valor = valor.doubleValue();
    }

    public static ConstructorExpression<MateriaUsuarioDTO> constructorExpression(QMateriaUsuario materiaUsuario) {
        return new QMateriaUsuarioDTO(
                materiaUsuario.id,
                materiaUsuario.ativo,
                materiaUsuario.valor
        );
    }
}

