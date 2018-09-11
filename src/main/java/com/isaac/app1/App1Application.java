package com.isaac.app1;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isaac.app1.Enums.TipoCliente;
import com.isaac.app1.repository.CidadeRepository;
import com.isaac.app1.repository.EstadoRepository;
import com.isaac.app1.repository.categoriaRepository;
import com.isaac.app1.repository.clienteRepository;
import com.isaac.app1.repository.enderecoRepository;
import com.isaac.app1.repository.produtoRepository;
import com.isaac.app1.resources.domain.Categoria;
import com.isaac.app1.resources.domain.Cidade;
import com.isaac.app1.resources.domain.Cliente;
import com.isaac.app1.resources.domain.Endereco;
import com.isaac.app1.resources.domain.Estado;
import com.isaac.app1.resources.domain.Produto;

@SpringBootApplication
public class App1Application implements CommandLineRunner {
	
	@Autowired
	private categoriaRepository categoriaRepository;
	
	@Autowired
	private produtoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private clienteRepository clienteRepository;
	
	@Autowired
	private enderecoRepository enderecoRepository;
	

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
		
		Estado est1 = new Estado(null, "Ceara");
		Estado est2 = new Estado(null, "Paraiba");
		
		Cidade c1 = new Cidade(null, "Fortaleza", est1);
		Cidade c2 = new Cidade(null, "Cajazeiras", est2);
		Cidade c3 = new Cidade(null, "Ipaumirim", est1);
		 
		est1.getCidades().addAll(Arrays.asList(c1, c3));
		est2.getCidades().addAll(Arrays.asList(c2));
		
		
		 estadoRepository.saveAll(Arrays.asList(est1, est2));
		 cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		 
		 Cliente cli1 = new Cliente(null, "Isaac Ramon", "isaacramonc@gmail.com", "06015588390", TipoCliente.PESSOAFISICA);
		 cli1.getTelefones().addAll(Arrays.asList("877987977","098098080980"));
		 Endereco end1 = new Endereco(null, "Cidade", "2384", "casa", "Pedras", "?????", cli1, c1);
		 Endereco end2 = new Endereco(null, "interior", "154", "casa", "São Luiz", "63340000", cli1, c3);
		 
		 cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		 
		 clienteRepository.saveAll(Arrays.asList(cli1));
		 enderecoRepository.saveAll(Arrays.asList(end1, end2));
		 
	}
}
