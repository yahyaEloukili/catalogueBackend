package com.sid.catalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sid.catalogue.dao.CategorieRepository;
import com.sid.catalogue.dao.ProduitRepository;
import com.sid.catalogue.entities.Categorie;
import com.sid.catalogue.entities.Produit;

@SpringBootApplication
public class CatalogueApplication implements CommandLineRunner{

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(CatalogueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//exposer les ids pour les produits 
		restConfiguration.exposeIdsFor(Produit.class);
		Categorie categorie = new Categorie(null,"Tech");
		Categorie categorie2 = new Categorie(null,"Tech2");
	categorieRepository.save(categorie);
	categorieRepository.save(categorie2);
		Produit p1 = new Produit(null,"Ordinateur Lx 45",6700,3,null);
		Produit p2 = new Produit(null,"Smartphone",3700,3,null);
		Produit p3 = new Produit(null,"able",6730,3,null);
		Produit p4 = new Produit(null,"able",6730,3,null);
		Produit p5 = new Produit(null,"able",6730,3,null);
		Produit p6 = new Produit(null,"able",6730,3,null);
		Produit p7 = new Produit(null,"able",6730,3,null);
		Produit p8 = new Produit(null,"able",6730,3,null);
		Produit p9 = new Produit(null,"able",6730,3,null);
		Produit p10 = new Produit(null,"able",6730,3,null);
		Produit p11 = new Produit(null,"able",6730,3,null);
		Produit p12 = new Produit(null,"able",6730,3,null);
		
		p1.setCategorie(categorie);
		p2.setCategorie(categorie);
		p3.setCategorie(categorie);
		produitRepository.save(p1);
		produitRepository.save(p2);
		produitRepository.save(p3);
		produitRepository.save(p4);
		produitRepository.save(p5);
		produitRepository.save(p6);
		produitRepository.save(p7);
		produitRepository.save(p8);
		produitRepository.save(p9);
		produitRepository.save(p10);
		produitRepository.save(p11);
		produitRepository.save(p12);
		
		
		
		
		produitRepository.findAll().forEach(pt->{
			System.out.println(pt.toString());
		});
	}

}
