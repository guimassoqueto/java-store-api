package com.guimassoqueto.storeapi.storeapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guimassoqueto.storeapi.storeapi.domain.Categoria;
import com.guimassoqueto.storeapi.storeapi.domain.Cidade;
import com.guimassoqueto.storeapi.storeapi.domain.Cliente;
import com.guimassoqueto.storeapi.storeapi.domain.Endereco;
import com.guimassoqueto.storeapi.storeapi.domain.Estado;
import com.guimassoqueto.storeapi.storeapi.domain.Produto;
import com.guimassoqueto.storeapi.storeapi.domain.enums.TipoCliente;
import com.guimassoqueto.storeapi.storeapi.repositories.CategoriaRepository;
import com.guimassoqueto.storeapi.storeapi.repositories.CidadeRepository;
import com.guimassoqueto.storeapi.storeapi.repositories.ClienteRepository;
import com.guimassoqueto.storeapi.storeapi.repositories.EnderecoRepository;
import com.guimassoqueto.storeapi.storeapi.repositories.EstadoRepository;
import com.guimassoqueto.storeapi.storeapi.repositories.ProdutoRepository;

@SpringBootApplication
public class StoreapiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(StoreapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null,  "Impressora", 800.00);
		Produto p3 = new Produto(null,  "Mouse", 80.00);

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", c1, cli1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", c1, cli1);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
