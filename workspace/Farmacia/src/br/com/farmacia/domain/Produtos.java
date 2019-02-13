package br.com.farmacia.domain;

public class Produtos {
	
	private int codigo;
	private String descricao;
	private int quantidade;
	private Double preco;
	private Fornecedores fornecedores = new Fornecedores();
	
	public Produtos(){
		
	}	
	
	public Produtos(int codigo, String descricao, int quantidade, Double preco, Fornecedores fornecedores) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.fornecedores = fornecedores;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Fornecedores getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}
	

}
