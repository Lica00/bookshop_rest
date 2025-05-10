package it.bookshop.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.bookshop.dao.LibroDao;
import it.bookshop.helpers.ResponseManager;
import it.bookshop.model.Libro;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LibroServiceImp implements LibroService{

	@Autowired LibroDao libroDao;
	
	@Override
	public Iterable<Libro> getAll() {
		return libroDao.findAll();
	}
	@Override
	public Libro save(Libro libro) {
		libroDao.save(libro);
		return libro;
	}

	@Override
	public Libro getById(int id) {
		Optional<Libro> libro = libroDao.findById(id);
		if( libro.isPresent() ) { return libro.get(); }
		else{ throw new EntityNotFoundException("Libro non trovato"); }
	}

	@Override
	public ObjectNode deleteById(int id) {
		Optional<Libro> libro = libroDao.findById(id);
		
		if( libro.isPresent() ){
			libroDao.deleteById(id);		
			ResponseManager res = new ResponseManager(200, "Libro eliminato");
			return res.getResponse();
		} else { return new ResponseManager(404, "Libro non trovato").getResponse(); }
	}

}
