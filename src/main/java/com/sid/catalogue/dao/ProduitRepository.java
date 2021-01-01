package com.sid.catalogue.dao;



import java.util.List;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.catalogue.entities.Produit;

import ch.qos.logback.core.net.SocketConnector.ExceptionHandler;
@CrossOrigin("*")
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	//http://localhost:8080/produits/search/byDesignation?mc=a
	@RestResource(path = "/byDesignation")
	public List<Produit> findByDesignationContains(@Param("mc") String designation);
	
	//http://localhost:8080/produits/search/byDesignationPage?mc=a&page=0&size=2
	@RestResource(path = "/byDesignationPage")
	public Page<Produit> findByDesignationContains(@Param("mc") String mc,Pageable pageable);
}
