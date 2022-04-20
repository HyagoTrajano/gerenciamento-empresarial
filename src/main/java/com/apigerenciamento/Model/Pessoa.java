package com.apigerenciamento.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_pessoa")
@Getter
@Setter
public class Pessoa {
    @Id
    @Column(name="id_pessoa")
    private long id_pessoa;

    @Column(name="matricula")
    private long matricula;
    
    @Column(name="nome_pessoa")
    private String nome_pessoa;
    
    @Column(name="nome_usuario")
    private String nome_usuario;

    @ManyToOne
    @JoinColumn(name = "id_area_pes")
    private Areas areas;

    @ManyToOne
    @JoinColumn(name = "id_pes_proj")
    private Projeto projeto;
}
