package com.apigerenciamento.Controller;

import java.util.List;
import java.util.Optional;

import com.apigerenciamento.Model.Projeto;
import com.apigerenciamento.Repository.ProjetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjetoController {
    
    @Autowired
    ProjetoRepository ppr;

    @GetMapping("/projetos")
	public ResponseEntity<List<Projeto>>getAllProjeto(){
		List<Projeto>projetoList = ppr.findAll();
		if(projetoList.isEmpty()) {
			System.out.println("nenhum projeto no sistema");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Projeto>>(projetoList, HttpStatus.OK);
		}
	}

    @GetMapping("/projeto/{id_projeto}")
	public ResponseEntity<Projeto>getOneProjeto(@PathVariable(value = "id_projeto") long id_projeto){
		java.util.Optional<Projeto>projetoO = ppr.findById(id_projeto);
		
		if(!projetoO.isPresent()) {
			System.out.println("pessoa nao cadastrado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Projeto>(projetoO.get(), HttpStatus.OK);
		}
	}

    @PostMapping("/projeto")
	public ResponseEntity<Projeto> saveProjeto(@RequestBody Projeto projeto){
		return new ResponseEntity<Projeto>(ppr.save(projeto), HttpStatus.CREATED);
	}

	@DeleteMapping("/projeto/{id_projeto}")
	public ResponseEntity <?> deleteProjeto(@PathVariable(value="id_projeto") long id_projeto){
		Optional<Projeto> ProjetoO = ppr.findById(id_projeto);
		if(!ProjetoO.isPresent()){
			System.out.println("projeto nao localizado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			ppr.delete(ProjetoO.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping("/projeto/{id_projeto}")
	public ResponseEntity<Projeto> updateProjeto(@PathVariable(value="id_projeto") long id_projeto, @RequestBody Projeto projeto){
		Optional<Projeto> ProjetoO = ppr.findById(id_projeto);
		if(!ProjetoO.isPresent()){
			System.out.println("projeto nao encontrado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
            projeto.setId_projeto(ProjetoO.get().getId_projeto());
			return new ResponseEntity<Projeto>(ppr.save(projeto), HttpStatus.OK);
		}
	}
}
