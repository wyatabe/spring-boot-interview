package com.wyatabe.interview.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wyatabe.interview.boot.domain.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {
	
	@Query(value="SELECT c FROM Cliente c WHERE LOWER(c.nomeCompleto) LIKE LOWER(:nomeCompleto)")
	public List<Cliente> findByNomeCompleto(@Param("nomeCompleto") String nomeCompleto);

	@Modifying
	@Query("UPDATE Cliente c SET c.nomeCompleto = :nomeCompleto WHERE c.id = :id")
	int setNomeCompleto(@Param("id") Long id, @Param("nomeCompleto") String nomeCompleto);
	
}