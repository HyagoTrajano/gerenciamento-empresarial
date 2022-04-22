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
public class Gerentes {
    
    @Id
    @Column(name = "id_gerente")
    private long id_gerente;

    @Column(name = "matricula_gerente")
    private long matricula_gerente;
    
    @Column(name = "nome_gerente")
    private String nome_gerente;
    
    @Column(name = "nome_usuario")
    private String nome_usuario;
    
    @Column(name = "setor_gerencia")
    private String setor_gerencia;

    // Getter e Setter são implementados pela anotation Lombok
}
