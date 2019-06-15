package com.frmurta.hackathon.usuario;

import com.frmurta.hackathon.abstracoes.AbstractDTO;
import com.frmurta.hackathon.example.QExample;
import com.frmurta.hackathon.example.QExampleDTO;
import com.frmurta.hackathon.usuario.materiausuario.MateriaUsuario;
import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.ConstructorExpression;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class UsuarioDTO extends AbstractDTO {

    public String name;
    public String email;

    public Double valorMedio;

    @Builder
    @QueryProjection
    public UsuarioDTO(Long id, Boolean ativo, String name, String email) {
        super(id, ativo);
        this.name = name;
        this.email = email;
    }

    public UsuarioDTO(List<MateriaUsuario> materiaUsuariosList){
        this.valorMedio = materiaUsuariosList.stream()
                .mapToDouble(materiaUsuario ->
                        materiaUsuario.getValor().doubleValue())
                .average()
                .getAsDouble();
    }

    public UsuarioDTO(Double totalPeso, Double totalAluno){

        BigDecimal total = new BigDecimal(totalAluno).divide(new BigDecimal(totalPeso),2, RoundingMode.UP);
        this.valorMedio = total.doubleValue();
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

