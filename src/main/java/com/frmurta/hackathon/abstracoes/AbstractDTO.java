package com.frmurta.hackathon.abstracoes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractDTO implements Serializable {

    private Long id;
    private Boolean ativo;
}
