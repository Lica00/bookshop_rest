package it.bookshop.service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.bookshop.model.Categoria;

public interface CategoriaService {

	Iterable<Categoria> getAll();
	Categoria getById( int id);
	Categoria save( Categoria cat);
	ObjectNode deleteById( int id );
	
}
