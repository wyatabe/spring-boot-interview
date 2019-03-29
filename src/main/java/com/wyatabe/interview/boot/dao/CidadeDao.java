package com.wyatabe.interview.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wyatabe.interview.boot.domain.Cidade;
import com.wyatabe.interview.boot.domain.Estado;

@Repository
public interface CidadeDao extends JpaRepository<Cidade, Long> {
	
	public List<Cidade> findByNomeIgnoreCase(String nome);
	
	public List<Cidade> findByEstado(Estado estado);

}
