package com.apigerenciamento.Repository;

import com.apigerenciamento.Model.Projeto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
    
}
