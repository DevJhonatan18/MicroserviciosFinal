package com.bardalez.microcursos.config;
/*
 * Aplicativo desarrollado para la clase de Java Expert
 * Autor: Cedric Bardalez (CJava Perú)
 * Version 1.0
 * www.cjavaperu.com
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages= "com.bardalez.microcursos.repository")
public class MongoConfig extends AbstractMongoConfiguration {
  
    @Override
    protected String getDatabaseName() {
        return "carritoCurso";
    }
  
    @Bean
    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 27017);
    }
}