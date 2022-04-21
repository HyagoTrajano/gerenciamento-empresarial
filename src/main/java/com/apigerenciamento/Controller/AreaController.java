package com.apigerenciamento.Controller;

import java.util.List;

import com.apigerenciamento.Model.Areas;
import com.apigerenciamento.Repository.AreasRepository;
import com.apigerenciamento.Repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AreaController {
    
    @Autowired
    AreasRepository ar;

    @Autowired
    PessoaRepository pr;

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
}
