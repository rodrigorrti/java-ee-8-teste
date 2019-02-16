package br.com.bytebank.banco.jdbc.dao;

import br.com.bytebank.banco.jdbc.entity.EntidadeAbstrata;

import java.util.List;

public interface DAO<E extends EntidadeAbstrata<Long>> {

	E get(Long id);
	
	List<E> listAll();
	
	void persist(E entity);
	
	void update(E entity);
}