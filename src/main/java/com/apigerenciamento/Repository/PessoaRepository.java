package com.apigerenciamento.Repository;

import com.apigerenciamento.Model.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
