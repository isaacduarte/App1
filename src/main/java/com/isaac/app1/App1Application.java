package com.isaac.app1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isaac.app1.repository.categoriaRepository;
import com.isaac.app1.resources.domain.Categoria;

@SpringBootApplication
public class App1Application implements CommandLineRunner {
	
	@Autowired
	private categoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(App1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null,"Escritorio");
		Categoria cat2 = new Categoria(null, "Informatica");
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
	}
}
