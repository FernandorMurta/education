package com.frmurta.hackathon.usuario.materiausuario;

import com.frmurta.hackathon.abstracoes.AbstractEntity;
import com.frmurta.hackathon.curso.Curso;
import com.frmurta.hackathon.materia.Materia;
import com.frmurta.hackathon.usuario.Usuario;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table (name = "MATERIA_USUARIO")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class MateriaUsuario extends AbstractEntity {

    @NotNull
    private BigDecimal peso;
    @NotNull
    @ManyToOne
    private Usuario usuario;
    @NotNull
    @ManyToOne
    private Materia materia;


    @Builder
    public MateriaUsuario(Long id, Boolean ativo, Usuario usuario, Materia materia, BigDecimal peso){
        super(id, ativo);
        this.usuario = usuario;
        this.materia = materia;
        this.peso = peso;
    }
}
