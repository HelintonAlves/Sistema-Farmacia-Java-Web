package br.com.farmacia.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;

public class ProdutosDAOTeste {

	@Test
	@Ignore
	public void Salvar() throws SQLException {
		
		Produtos p1 = new Produtos();

		p1.setDescricao("Dipirona");
		p1.setPreco(2.99);
		p1.setQuantidade(12);

		Fornecedores f = new Fornecedores();
		f.setCodigo(3);
		p1.setFornecedores(f);

		ProdutosDAO pdao = new ProdutosDAO();

		pdao.salvar(p1);

	}
	
	@Test
	@Ignore
	public void Listar() throws SQLException{
		
		ProdutosDAO pdao = new ProdutosDAO();
		ArrayList<Produtos> lista = pdao.listar();
		
		for(Produtos p : lista){
			
			System.out.println("Código do Produto: " + p.getCodigo());
			System.out.println("Descrição do Produto: " + p.getDescricao());
			System.out.println("Valor do Produto: " + p.getPreco());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println("Código do Fornecedor: " + p.getFornecedores().getCodigo());
			System.out.println("Descricao do Fornecedor: " + p.getFornecedores().getDescricao());
			System.out.println("");
			
		}
	}
	
	@Test
	@Ignore
	public void excluir()throws SQLException{
		
		Produtos p = new Produtos();
		p.setCodigo(2);
		
		ProdutosDAO pdao = new ProdutosDAO();
		pdao.excluir(p);
		
	}
	
	@Test
	public void editar() throws SQLException{
		
		Produtos p = new Produtos();
		p.setCodigo(1);
		p.setDescricao("Aspirina");		
		p.setQuantidade(20);
		p.setPreco(4.99);
		
		Fornecedores f = new Fornecedores();
		f.setCodigo(3);
		
		p.setFornecedores(f);
		
		ProdutosDAO  pdao = new ProdutosDAO();
		pdao.editar(p);
		
	}
}
