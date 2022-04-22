package com.apigerenciamento.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_projetos")
@Getter
@Setter
public class Projeto {
    @Id
    @Column(name="id_projeto")
    private long id_projeto;

    @Column(name="registro_projeto")
    private String registro_projeto;

    @Column(name="area_projeto")
    private String area_projeto;

    @Column(name="nome_projeto")
    private String nome_projeto;
    
    @Column(name="responsavel_projeto")
    private String responsavel_projeto;

    @Column(name="gerente_projeto")
    private String gerente_projeto;

    @Column(name="metodologia_agil")
    private String metodologia_agil;

    @Column(name="n_reuniao")
    private long n_reuniao;

    @Column(name="momento_projeto")
    private String momento_projeto;

    @OneToMany(mappedBy = "id_pessoa")
    @JsonIgnore
    private List<Pessoa> pessoa;

    //Getters e Setters estão sendo produzidos pela anotation do lombok
}