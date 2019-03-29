package com.wyatabe.interview.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wyatabe.interview.boot.dao.ClienteDao;
import com.wyatabe.interview.boot.domain.Cliente;

@Service @Transactional(readOnly = false)
public class ClienteService extends AbstractService<Cliente, ClienteDao> {
	
	public List<Cliente> buscarPorNomeCompleto(String nomeCompleto) {
		return dao.findByNomeCompleto("%" + nomeCompleto + "%");
	}

	public int alterarNomeCompleto(Long id, String nomeCompleto) {
		return dao.setNomeCompleto(id, nomeCompleto);
	}
	
}
