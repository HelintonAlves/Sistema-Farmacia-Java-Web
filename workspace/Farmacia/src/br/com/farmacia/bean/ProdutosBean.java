package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBProdutos")
@ViewScoped
public class ProdutosBean {
	
	private Produtos produtos;
	private ArrayList<Produtos> itens;
	private ArrayList<Produtos> itensFiltrados;
	private ArrayList<Fornecedores> comboFornecedores;
	
	
	public Produtos getProdutos() {
		return produtos;
	}
	
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	
	public ArrayList<Produtos> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Produtos> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<Produtos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	public ArrayList<Fornecedores> getComboFornecedores() {
		return comboFornecedores;
	}
	
	public void setComboFornecedores(ArrayList<Fornecedores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}
	
	@PostConstruct
	public void prepararPesquisa(){		
				
		try {
			ProdutosDAO pdao = new ProdutosDAO();
			itens = pdao.listar();
			
		} catch (SQLException e) {
			
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
			
		}
		
	}
	
	
	public void prepararNovo(){
		
		try{
		produtos = new Produtos();		
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		comboFornecedores = fdao.listar();
				
		}catch(SQLException e){
			JSFUtil.adicionarMensagemErro("ex.getMessagem()");
			e.printStackTrace();
		}
	}
	
	public void novo(){
		
		try {
			ProdutosDAO pdao = new ProdutosDAO();
			pdao.salvar(produtos);
			
			itens = pdao.listar();			
			
			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso!");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
		
	}
	
	public void Excluir(){
		
		try {
			
			ProdutosDAO pdao = new ProdutosDAO();
			pdao.excluir(produtos);
			
			itens = pdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto excluido com sucesso!");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
		
	}
	
	public void Editar(){
		
		try {
			
			ProdutosDAO pdao = new ProdutosDAO();
			pdao.editar(produtos);
			
			
			itens = pdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso!");
			
		} catch (Exception e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
		
	}
	
}
