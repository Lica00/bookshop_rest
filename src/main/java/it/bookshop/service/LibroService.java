package it.bookshop.service;


import com.fasterxml.jackson.databind.node.ObjectNode;

import it.bookshop.model.Libro;

public interface LibroService {

	Iterable<Libro> getAll();
	Libro getById( int id);
	Libro save( Libro lib);
	ObjectNode deleteById( int id );

	
}
