package com.sid.catalogue.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P1",types = Produit.class)
public interface ProduitProjection {
//http://localhost:8080/produits?projection=P1
	public double getPrice();
}
