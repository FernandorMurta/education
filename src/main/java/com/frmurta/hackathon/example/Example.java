package com.frmurta.hackathon.example;

import com.frmurta.hackathon.abstracoes.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "EXAMPLE")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Example extends AbstractEntity {

    private String name;

    @Builder
    public Example(Long id, Boolean ativo, String name){
        super(id, ativo);
        this.name = name;
    }
}
