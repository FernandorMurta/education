package com.frmurta.hackathon.usuario;

import com.frmurta.hackathon.abstracoes.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "USUARIO")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Usuario extends AbstractEntity {

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;

    @Builder
    public Usuario(Long id, Boolean ativo, String name, String email, String password){
        super(id, ativo);
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
