package it.bookshop.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.bookshop.dao.CategoriaDao;
import it.bookshop.helpers.ResponseManager;
import it.bookshop.model.Categoria;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaServiceImp implements CategoriaService{

	@Autowired CategoriaDao categoriaDao;
	
	@Override
	public Iterable<Categoria> getAll() {
		return categoriaDao.findAll();
	}
	
	@Override
	public Categoria save( Categoria cat ){ 
		categoriaDao.save(cat); 
		return cat;
	}
	

	@Override
	public Categoria getById(int id) {	
		Optional<Categoria> cat = categoriaDao.findById(id);
		if( cat.isPresent() ) { return cat.get(); }
		else{ throw new EntityNotFoundException("Categoria non trovata"); }
	}

	@Override
	public ObjectNode deleteById(int id) {
		Optional<Categoria> cat = categoriaDao.findById(id);
		
		if( cat.isPresent() ){
			categoriaDao.deleteById(id);
			ResponseManager res = new ResponseManager(200, "Categoria eliminata");
			return res.getResponse();
		} else { return new ResponseManager(404, "Categoria non trovata").getResponse(); }
			
	}

}
