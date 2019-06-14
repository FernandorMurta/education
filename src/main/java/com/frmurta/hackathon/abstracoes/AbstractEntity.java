package com.frmurta.hackathon.abstracoes;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@EqualsAndHashCode
@NoArgsConstructor
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "globalSequenceGenerator")
    @SequenceGenerator(name = "globalSequenceGenerator", sequenceName = "global_sequence", allocationSize = 1)
    private Long id;

    private Boolean ativo = true;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdDate;


    @UpdateTimestamp
    private Date dataAtualizacao;

    private Date dataExclusao;

    public AbstractEntity(Long id, boolean ativo) {
        this.id = id;
        this.ativo = ObjectUtils.isEmpty(ativo) || ativo;
    }
}

