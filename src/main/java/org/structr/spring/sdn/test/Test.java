/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.structr.spring.sdn.test;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.transaction.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.structr.spring.sdn.test.model.Product;
import org.structr.spring.sdn.test.repository.ProductRepository;

/**
 * Runnable Test class.
 *
 * @author Axel Morgner
 */
public class Test {

	public static void main(final String[] args) {

		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(App.class, ProductRepository.class);
		context.scan("org.structr.spring.sdn.test");
		context.scan("org.structr.spring.sdn.test.model");
		context.scan("org.structr.spring.sdn.test.repository");
		context.refresh();

		final App app = context.getBean(App.class);
		final Session s = app.getSessionFactory().openSession(app.neo4jServer().url());

		ProductRepository productRepository = context.getBean(ProductRepository.class);
		
		try (Transaction tx = s.beginTransaction()) {

			final Iterable<Product> products = productRepository.findAll();
			for (final Product p : products) {

				System.out.println(p);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
