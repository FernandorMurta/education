package com.frmurta.hackathon.areaatuacao;

import com.frmurta.hackathon.abstracoes.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "AREA_ATUACAO")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class AreaAtuacao extends AbstractEntity {

    private String name;

    @Builder
    public AreaAtuacao(Long id, Boolean ativo, String name){
        super(id, ativo);
        this.name = name;
    }
}
