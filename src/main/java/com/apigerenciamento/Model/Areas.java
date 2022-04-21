package com.apigerenciamento.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_area")
@Setter
@Getter
public class Areas {
    @Id
    private long id_area;

    @NotNull
    private String codigo_area;
    
    @NotNull
    private String nome_area; 

    @OneToMany(mappedBy = "id_pessoa")
    @JsonIgnore
    private List<Pessoa> pessoa;

    //Getters e Setters estão sendo produzidos pela anotation do lombok
}
