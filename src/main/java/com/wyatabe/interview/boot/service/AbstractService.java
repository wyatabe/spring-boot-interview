package com.wyatabe.interview.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional(readOnly = false)
public abstract class AbstractService<DOMAIN, DAO extends JpaRepository<DOMAIN, Long>> {
	
	@Autowired
	protected DAO dao;
	
	@Transactional(readOnly = true)
	public List<DOMAIN> buscarTodos() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional<DOMAIN> buscarPorId(Long id) {
		return dao.findById(id);
	}
		
	public DOMAIN salvar(DOMAIN domain) {
		return dao.save(domain);
	}
	
	public void excluir(Long id) {
		dao.deleteById(id);
	}
	
}