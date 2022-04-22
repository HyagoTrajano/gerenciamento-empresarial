package com.apigerenciamento.Repository;

import com.apigerenciamento.Model.ProjetoGerencia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoGerenteRepository extends JpaRepository<ProjetoGerencia, Long>{
    
}
