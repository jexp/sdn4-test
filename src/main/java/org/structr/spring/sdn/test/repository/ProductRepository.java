/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.structr.spring.sdn.test.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import org.structr.spring.sdn.test.model.Product;
import java.util.*;

/**
 * Repository interface for products
 *
 * @author Axel Morgner
*/
@Repository
public interface ProductRepository extends GraphRepository<Product> {

	// @Override
	// @Query("MATCH (p:Product) RETURN p")
	// public List<Product> findAll();

}
