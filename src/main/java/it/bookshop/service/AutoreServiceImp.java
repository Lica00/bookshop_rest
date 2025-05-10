package it.bookshop.service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.bookshop.dao.AutoreDao;
import it.bookshop.helpers.ResponseManager;
import it.bookshop.model.Autore;
import jakarta.persistence.EntityNotFoundException;


@Service 
public class AutoreServiceImp implements AutoreService {
	
	@Autowired 	AutoreDao autoreDao;

	@Override 
	public Iterable<Autore> getAll() {
		return autoreDao.findAll();
	}
	
	@Override
	public Autore save( Autore autore ) {
		autoreDao.save(autore);
		return autore;
	}

	@Override
	public Autore getById(int id) {
		Optional<Autore> autore = autoreDao.findById(id);
		if( autore.isPresent() ) { return autore.get(); }
		else{ throw new EntityNotFoundException("Autore non trovato"); }
	}
	


	@Override
	public ObjectNode deleteById( int id) {
		Optional<Autore> autore = autoreDao.findById(id);

		if( autore.isPresent() ) { 
			autoreDao.delete( autore.get() );                     
			ResponseManager man = new ResponseManager( 200, "Autore eliminato");
			return man.getResponse(); 
		} else{ return new ResponseManager( 404, "Autore non trovato").getResponse(); }
	}


}
