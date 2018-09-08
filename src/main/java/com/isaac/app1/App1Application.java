package com.isaac.app1;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isaac.app1.repository.categoriaRepository;
import com.isaac.app1.repository.produtoRepository;
import com.isaac.app1.resources.domain.Categoria;
import com.isaac.app1.resources.domain.Produto;

@SpringBootApplication
public class App1Application implements CommandLineRunner {
	
	@Autowired
	private categoriaRepository categoriaRepository;
	
	@Autowired
	private produtoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(App1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null,"Escritorio");
		Categoria cat2 = new Categoria(null, "Informatica");
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);
		
		cat1.getProduto().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProduto().addAll(Arrays.asList(p2));
		
		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1,cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	
		
	}
}
