package com.frmurta.hackathon.faculdade;

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
public class FaculdadeDTO extends AbstractDTO {

    public String password;
    public String name;
    public String login;

    @Builder
    @QueryProjection
    public FaculdadeDTO(Long id, Boolean ativo, String name, String password, String login) {
        super(id, ativo);
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public static ConstructorExpression<FaculdadeDTO> constructorExpression(QFaculdade faculdade) {
        return new QFaculdadeDTO(
                faculdade.id,
                faculdade.ativo,
                faculdade.name,
                faculdade.email,
                faculdade.password
        );
    }
}

