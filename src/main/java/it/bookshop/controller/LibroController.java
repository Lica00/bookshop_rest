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

import it.bookshop.model.Libro;
import it.bookshop.service.LibroService;


@RestController
@RequestMapping("/libri")
public class LibroController {

	@Autowired LibroService libroService;
	
	@GetMapping("all")
	public Iterable<Libro> getAllLibri(){
		return libroService.getAll();
	}
	
	@GetMapping("{id}")
	public Libro getLibroById( @PathVariable( name = "id" ) int id ){ 
		return libroService.getById(id);
	}
	
	@PostMapping("save")
	public Libro saveLibro( @RequestBody Libro lib){ 
		return libroService.save(lib);
	}

	@PutMapping("update")
	public Libro updateLibro( @RequestBody Libro lib){ 
		return libroService.save(lib);
	}
	
	@DeleteMapping("delete/{id}")
	public ObjectNode deleteLibro(@PathVariable( name = "id" ) int id){
		return libroService.deleteById(id);
	}
	
}
