package com.wyatabe.interview.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wyatabe.interview.boot.dao.CidadeDao;
import com.wyatabe.interview.boot.domain.Cidade;
import com.wyatabe.interview.boot.domain.Estado;

@Service @Transactional(readOnly = false)
public class CidadeService extends AbstractService<Cidade, CidadeDao> {

	@Transactional(readOnly = true)
	public List<Cidade> buscarPorNome(String nome) {
		return dao.findByNomeIgnoreCase(nome);
	}
	
	@Transactional(readOnly = true)
	public List<Cidade> buscarPorEstado(Estado estado) {
		return dao.findByEstado(estado);
	}

}
