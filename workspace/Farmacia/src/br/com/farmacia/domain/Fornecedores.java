package br.com.farmacia.domain;

public class Fornecedores {
	
	private int codigo;
	private String descricao;
	
	public Fornecedores(){
		
	}	
	
	public Fornecedores(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
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
	
	@Override
	public String toString() {
		String saida = codigo + " - " + descricao;
		return saida;
	}

}
