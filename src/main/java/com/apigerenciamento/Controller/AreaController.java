package com.apigerenciamento.Controller;

import java.util.List;
import java.util.Optional;

import com.apigerenciamento.Model.Areas;
import com.apigerenciamento.Model.Pessoa;
import com.apigerenciamento.Model.Projeto;
import com.apigerenciamento.Repository.AreasRepository;
import com.apigerenciamento.Repository.PessoaRepository;
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
public class AreaController {
    
    @Autowired
    AreasRepository ar;

    @Autowired
    PessoaRepository pr;

	@Autowired
	ProjetoRepository ppr;

    @GetMapping("/areas")
	public ResponseEntity<List<Areas>>getAllAreas(){
		List<Areas>areaList = ar.findAll();
		if(areaList.isEmpty()) {
			System.out.println("erro do sistema no endpoint evento");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Areas>>(areaList, HttpStatus.OK);
		}
	}

    @GetMapping("/pessoa")
	public ResponseEntity<List<Pessoa>>getAllPessoa(){
		List<Pessoa>pessoaList = pr.findAll();
		if(pessoaList.isEmpty()) {
			System.out.println("erro do sistema no endpoint evento");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Pessoa>>(pessoaList, HttpStatus.OK);
		}
	}

	@GetMapping("/pessoa/{id_pessoa}")
	public ResponseEntity<Pessoa>getOnePessoa(@PathVariable(value = "id_pessoa") long id_pessoa){
		java.util.Optional<Pessoa>pessoaA = pr.findById(id_pessoa);
		
		if(!pessoaA.isPresent()) {
			System.out.println("pessoa nao cadastrado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Pessoa>(pessoaA.get(), HttpStatus.OK);
		}
	}

	@PostMapping("/pessoa")
	public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa){
		return new ResponseEntity<Pessoa>(pr.save(pessoa), HttpStatus.CREATED);
	}

	@DeleteMapping("/pessoa/{id_pessoa}")
	public ResponseEntity <?> deletePessoa(@PathVariable(value="id_pessoa") long id_pessoa){
		Optional<Pessoa> PessoaA = pr.findById(id_pessoa);
		if(!PessoaA.isPresent()){
			System.out.println("pessoa nao localizado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			pr.delete(PessoaA.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping("/pessoa/{id_pessoa}")
	public ResponseEntity<Pessoa> updatePessoa(@PathVariable(value="id_pessoa") long id_pessoa, @RequestBody Pessoa pessoa){
		Optional<Pessoa> PessoaA = pr.findById(id_pessoa);
		if(!PessoaA.isPresent()){
			System.out.println("pessoa nao encontrado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			pessoa.setId_pessoa(PessoaA.get().getId_pessoa());
			return new ResponseEntity<Pessoa>(pr.save(pessoa), HttpStatus.OK);
		}
	}

	@GetMapping("/projetos")
	public ResponseEntity<List<Projeto>>getAllProjeto(){
		List<Projeto>projetoList = ppr.findAll();
		if(projetoList.isEmpty()) {
			System.out.println("erro do sistema no endpoint evento");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Projeto>>(projetoList, HttpStatus.OK);
		}
	}
}
