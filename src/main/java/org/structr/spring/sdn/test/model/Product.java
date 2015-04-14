/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.structr.spring.sdn.test.model;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Entity class to represent a Product entity within the Northwind example dataset.
 * 
 * @author Axel Morgner
 */
@NodeEntity
public class Product {
	
	Long id;
	
	// String attributes: productID, productName, supplierID, categoryID, quantityPerUnit
	public String productID;
	public String productName;
	public String supplierID;
	public String categoryID;
	public String quantityPerUnit;
	
	// Float attributes:
	// unitPrice
	public Double unitPrice;
	
	// Integer attributes: unitsInStock, unitsOnOrder, reorderLevel
	public Integer unitsInStock;
	public Integer unitsOnOrder;
	public Integer reorderLevel;
	
	// Boolean attributes: discontinued
	public Boolean discontinued;
	
}
