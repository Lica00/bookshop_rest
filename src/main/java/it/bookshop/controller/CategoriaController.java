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

import it.bookshop.model.Categoria;
import it.bookshop.service.CategoriaService;

@RestController
@RequestMapping("/categorie")
public class CategoriaController {

	@Autowired CategoriaService categoriaService;
	
	@GetMapping("all")
	public Iterable<Categoria> getAllCategorie(){ 
		return categoriaService.getAll();
	}
	
	@GetMapping("{id}")
	public Categoria getCategoriaById( @PathVariable( name = "id" ) int id ){
		return categoriaService.getById(id);
	}
	
	@PostMapping("save")
	public Categoria saveCategoria(  @RequestBody Categoria cat ){ 
		return categoriaService.save(cat);
	}
	
	@PutMapping("update")
	public Categoria updateCategoria(  @RequestBody Categoria cat ){ 
		return categoriaService.save(cat);
	}
	
	@DeleteMapping("delete/{id}")
	public ObjectNode deleteCategoria( @PathVariable( name = "id" ) int id  ) { 
		return categoriaService.deleteById(id); 
	}
}
