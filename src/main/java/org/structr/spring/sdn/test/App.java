/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.structr.spring.sdn.test;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Axel Morgner
 */
@Configuration
@EnableNeo4jRepositories("org.structr.spring.sdn.test.repository")
@EnableTransactionManagement
// @ComponentScan("org.structr.string.sdn.test.model")
public class App extends Neo4jConfiguration {

	public static final int NEO4J_PORT = 7474;
	
	@Bean
	@Override
	public SessionFactory getSessionFactory() {
		System.setProperty("username", "neo4j");
		System.setProperty("password", "admin");
		return new SessionFactory("org.structr.spring.sdn.test.model");
	}

	@Bean
	@Override
	public Neo4jServer neo4jServer() {
		return new RemoteServer("http://localhost:" + NEO4J_PORT);
	}

	@Bean
	@Override
	// @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Session getSession() throws Exception {
		return super.getSession();
	}

}
