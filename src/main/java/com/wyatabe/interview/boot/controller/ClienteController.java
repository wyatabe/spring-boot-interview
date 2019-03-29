package com.wyatabe.interview.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wyatabe.interview.boot.domain.Cliente;
import com.wyatabe.interview.boot.exception.ObjectNotFoundException;
import com.wyatabe.interview.boot.service.ClienteService;

import io.swagger.annotations.ApiParam;

@RestController
public class ClienteController {

	@Autowired
	ClienteService service;
	
	@PostMapping("/cliente")
	Cliente salvar(@ApiParam("Person information for a new person to be created.") @RequestBody Cliente cliente) {
		return service.salvar(cliente);
	}
	
	@GetMapping("/cliente")
	List<Cliente> buscarTodos() {
		return service.buscarTodos();
	}

	@GetMapping("/cliente/{id}")
	Cliente buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id)
				.orElseThrow(() -> new ObjectNotFoundException(Cliente.class, id));
	}
	
	@GetMapping("/cliente/buscarPorNome/{nome}")
	List<Cliente> buscarPorNome(@PathVariable String nome) {
		return service.buscarPorNomeCompleto(nome);
	}
		
	@DeleteMapping("/cliente/{id}")
	void excluir(@PathVariable Long id) {
		service.excluir(id);
	}

	@PutMapping("/cliente/{id}")
	Cliente atualizar(@RequestBody Cliente newCliente, @PathVariable Long id) {
		return service.buscarPorId(id)
			.map(cliente -> {
				cliente.setNomeCompleto(newCliente.getNomeCompleto());
				return service.salvar(cliente);
			})
			.orElseThrow(() -> new ObjectNotFoundException(Cliente.class, id));
	}

}