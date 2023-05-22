package com.guimassoqueto.storeapi.storeapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guimassoqueto.storeapi.storeapi.domain.Categoria;
import com.guimassoqueto.storeapi.storeapi.repositories.CategoriaRepository;

@SpringBootApplication
public class StoreapiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository catRepository;

	public static void main(String[] args) {
		SpringApplication.run(StoreapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		catRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
