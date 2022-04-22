package com.apigerenciamento.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_projetos_gestao")
@Getter
@Setter
public class ProjetoGerencia {

    @Id
    @Column(name="id_pro_gestao")
    private long id_pro_gestao;

    @Column(name="tipo_projeto")
    private String tipo_projeto;

    // Getter e Setter são gerados pela anotation Lombok
}
