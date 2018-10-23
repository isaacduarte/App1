package com.isaac.app1;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isaac.app1.Enums.EstadoPagamento;
import com.isaac.app1.Enums.TipoCliente;
import com.isaac.app1.repository.CidadeRepository;
import com.isaac.app1.repository.EstadoRepository;
import com.isaac.app1.repository.ItemPedidoRepository;
import com.isaac.app1.repository.PagamentoRepository;
import com.isaac.app1.repository.PedidoRepository;
import com.isaac.app1.repository.categoriaRepository;
import com.isaac.app1.repository.clienteRepository;
import com.isaac.app1.repository.enderecoRepository;
import com.isaac.app1.repository.produtoRepository;
import com.isaac.app1.resources.domain.Categoria;
import com.isaac.app1.resources.domain.Cidade;
import com.isaac.app1.resources.domain.Cliente;
import com.isaac.app1.resources.domain.Endereco;
import com.isaac.app1.resources.domain.Estado;
import com.isaac.app1.resources.domain.ItemPedido;
import com.isaac.app1.resources.domain.Pagamento;
import com.isaac.app1.resources.domain.PagamentoComBoleto;
import com.isaac.app1.resources.domain.PagamentoComCartao;
import com.isaac.app1.resources.domain.Pedido;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(App1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null,"Escritorio");
		Categoria cat2 = new Categoria(null, "Informatica");
		Categoria cat3 = new Categoria(null, "Quarto");
		Categoria cat4 = new Categoria(null, "Games");
		Categoria cat5 = new Categoria(null, "Banheiro");
		Categoria cat6 = new Categoria(null, "sala");
		Categoria cat7 = new Categoria(null, "Cozinha");
		Categoria cat8 = new Categoria(null, "Sexual");
		Categoria cat9 = new Categoria(null, "Literario");
		Categoria cat10 = new Categoria(null, "Musicas");
		Categoria cat11 = new Categoria(null, "Video");
		Categoria cat12 = new Categoria(null, "Interterimento");
		
		
		
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);
		
		cat1.getProduto().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProduto().addAll(Arrays.asList(p2));
		
		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1,cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10,
				 cat11, cat12));
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
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm");
		 
		 Pedido pe1 = new Pedido(null, sdf.parse("15/09/2018 16:33"), cli1, end1);
		 Pedido pe2 = new Pedido(null, sdf.parse("16/09/2018 08:10"), cli1, end2);
		 
		 Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pe1, 6);
		 pe1.setPagamento(pag1);
		 
		 Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pe2, sdf.parse("20/09/2018 11:00"), null);
		 pe2.setPagamento(pag2);
		 
		 cli1.getPedido().addAll(Arrays.asList(pe1, pe2));	 
		 
		 pedidoRepository.saveAll(Arrays.asList(pe1, pe2));
		 pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));
		 
		 ItemPedido it1 = new ItemPedido(pe1, p1, 0.00, 1, 10.00);
		 ItemPedido it2 = new ItemPedido(pe1, p3, 1.00, 3, 200.00);
		 ItemPedido it3 = new ItemPedido(pe2, p2, 2.99, 2, 2.50);
		 
		 pe1.getItempedido().addAll(Arrays.asList(it1, it2));
		 pe2.getItempedido().addAll(Arrays.asList(it3));
		 
		 p1.getItempedido().addAll(Arrays.asList(it1));
		 p2.getItempedido().addAll(Arrays.asList(it3));
		 p3.getItempedido().addAll(Arrays.asList(it2));
		 
		 itemPedidoRepository.saveAll(Arrays.asList(it1, it2, it3));
		 
		 
	}
}
