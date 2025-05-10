package it.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.bookshop.model.Autore;
import it.bookshop.service.AutoreService;


@RestController                 
@RequestMapping("/autori")     
public class AutoreController {
	
	@Autowired AutoreService autoreService; 
	
	@GetMapping("all")
	public Iterable<Autore> getAllAutore(){ 
		return autoreService.getAll();
	}

	@GetMapping("/{id}")    
	public Autore getAutoreById(@PathVariable("id") int id ){
		return autoreService.getById(id);
	}
 
	
	@PostMapping("save") 
	public Autore saveAutore( @RequestBody Autore aut ){	
		return autoreService.save(aut);
	}
	
	@PutMapping("update") 
	public Autore updateAutore( @RequestBody Autore aut ){
		return autoreService.save(aut);
	}
	
	@DeleteMapping("delete/{id}")
	public ObjectNode deleteAutore( @PathVariable( name = "id") int id ){ 
		return autoreService.deleteById(id); 
	}
	

}




