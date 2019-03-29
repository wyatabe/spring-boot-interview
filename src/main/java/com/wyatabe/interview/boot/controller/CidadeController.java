package com.wyatabe.interview.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wyatabe.interview.boot.domain.Cidade;
import com.wyatabe.interview.boot.domain.Estado;
import com.wyatabe.interview.boot.exception.ObjectNotFoundException;
import com.wyatabe.interview.boot.service.CidadeService;

@RestController
public class CidadeController {

	@Autowired
	CidadeService service;
	
	@PostMapping(value = "/cidade", produces = MediaType.APPLICATION_JSON_VALUE)
	Cidade salvar(@RequestBody Cidade cidade) {
		return service.salvar(cidade);
	}
	
	@GetMapping(value = "/cidade", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Cidade> buscarTodos() {
		return service.buscarTodos();
	}

	@GetMapping(value = "/cidade/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	Cidade buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id)
				.orElseThrow(() -> new ObjectNotFoundException(Cidade.class, id));
	}
	
	@GetMapping(value = "/cidade/buscarPorNome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Cidade> buscarPorNome(@PathVariable String nome) {
		return service.buscarPorNome(nome);
	}
	
	@GetMapping(value = "/cidade/buscarPorEstado/{estado}", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Cidade> buscarPorEstado(@PathVariable Estado estado) {
		return service.buscarPorEstado(estado);
	}
	
	@DeleteMapping("/cidade/{id}")
	void excluir(@PathVariable Long id) {
		service.excluir(id);
	}

	@PutMapping(value = "/cidade/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	Cidade atualizar(@RequestBody Cidade newCidade, @PathVariable Long id) {
		return service.buscarPorId(id)
			.map(cidade -> {
				cidade.setNome(newCidade.getNome());
				return service.salvar(cidade);
			})
			.orElseThrow(() -> new ObjectNotFoundException(Cidade.class, id));
	}

}