package it.bookshop.service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.bookshop.model.Autore;



public interface AutoreService {
	
	Iterable<Autore> getAll();     
	Autore getById( int id);     
	Autore save( Autore aut );      
	ObjectNode deleteById( int varId );  

}


