package com.frmurta.hackathon.materia;

import com.frmurta.hackathon.abstracoes.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "MATERIA")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Materia extends AbstractEntity {

    private String name;

    @Builder
    public Materia(Long id, Boolean ativo, String name){
        super(id, ativo);
        this.name = name;
    }
}
