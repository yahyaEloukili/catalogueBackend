package com.sid.catalogue.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sid.catalogue.dao.CategorieRepository;
import com.sid.catalogue.dao.ProduitRepository;
import com.sid.catalogue.entities.Categorie;
import com.sid.catalogue.entities.Produit;


@RestController
public class ProduitController {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	CategorieRepository categorieRepository;
	
	@GetMapping(value="/listProduits")
	public Page<Produit> listProduits(@RequestParam(name="page",defaultValue = "0") int page,@RequestParam(name="size",defaultValue = "5")int size){
		return produitRepository.findAll(PageRequest.of(page, size));
	}
	@GetMapping(value="/test")
	public String listProduits(){
		return "Hello world";
	}
	@GetMapping(value="/listProduitsByDesignation")
	public Page<Produit> listProduits2(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5")int size,@RequestParam(defaultValue = "")  String mc){
		return produitRepository.findByDesignationContains(mc,PageRequest.of(page, size));
	}
	@GetMapping(value="/listProduits/{id}")
	public Produit listProduits2(@PathVariable Long id){
		return produitRepository.findById(id).get();
	}
	
	@PutMapping(value = "listProduits/{id}")
	public Produit update(@PathVariable(name = "id") Long id,@RequestBody Produit p) {
		p.setId(id);
		return produitRepository.save(p);
	}
	
	@PostMapping(value = "listProduits/{categorieId}")
	public Produit save(@RequestBody Produit p,@PathVariable Long categorieId) {
		Categorie c = categorieRepository.findById(categorieId).get();
		if(c !=null) {
			p.setCategorie(c);
		}else {
			throw new RuntimeException("Categorie not found with this id");
		}
		
	
		return produitRepository.save(p);
	}
	
	@DeleteMapping(value="/listProduits/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
	
		 produitRepository.deleteById(id);
	}
	
	
}
