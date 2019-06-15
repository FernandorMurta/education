package com.frmurta.hackathon.usuario;

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
public class UsuarioDTO extends AbstractDTO {

    public String name;
    public String email;

    @Builder
    @QueryProjection
    public UsuarioDTO(Long id, Boolean ativo, String name, String email) {
        super(id, ativo);
        this.name = name;
        this.email = email;
    }

    public static ConstructorExpression<UsuarioDTO> constructorExpression(QUsuario usuario) {
        return new QUsuarioDTO(
                usuario.id,
                usuario.ativo,
                usuario.name,
                usuario.email
        );
    }
}

