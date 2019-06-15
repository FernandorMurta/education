package com.frmurta.hackathon.faculdade;

import com.frmurta.hackathon.abstracoes.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "FACULDADE")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Faculdade  extends AbstractEntity {

    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String name;

}
