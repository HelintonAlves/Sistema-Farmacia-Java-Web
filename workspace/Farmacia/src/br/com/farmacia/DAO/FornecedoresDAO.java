package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConexaoFactory;

public class FornecedoresDAO {
	
	public void salvar(Fornecedores f)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao) ");
		sql.append("VALUES(?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();
		
	}
	
	public void excluir(Fornecedores f) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");		
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, f.getCodigo());
		comando.executeUpdate();
		
	}
	
	public void editar(Fornecedores f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setInt(2, f.getCodigo());
		comando.executeUpdate();
	}
	
	public Fornecedores buscaPorCodigo(Fornecedores f)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setInt(1, f.getCodigo());
		
		ResultSet resultado = comando.executeQuery();
		Fornecedores retorno = null;
		
		if(resultado.next()){
			retorno = new Fornecedores();
			retorno.setCodigo(resultado.getInt("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}		
		
		return retorno;		
	}
	
	public ArrayList<Fornecedores> listar () throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();
		
		while(resultado.next()){
			Fornecedores f = new Fornecedores();
			f.setCodigo(resultado.getInt("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			
			lista.add(f);
		}
		
		return lista;
		
	}
	
	public ArrayList<Fornecedores> buscarPorDescricao(Fornecedores f) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");		
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, "%" + f.getDescricao() + "%");
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();
		
		while(resultado.next()){
			Fornecedores item = new Fornecedores();
			item.setCodigo(resultado.getInt("codigo"));
			item.setDescricao(resultado.getString("descricao"));
			
			lista.add(item);
		}
		
		return lista;
		
	}
	
	
	
	public static void main(String[] args) {
		/*Fornecedores f1 = new Fornecedores();
		f1.setDescricao("Descrição 1");
		
		Fornecedores f2 = new Fornecedores();
		f2.setDescricao("Descrição 2");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("Salvo com sucesso!");
		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println("Erro no banco!!");
		}		
		
		Fornecedores f1 = new Fornecedores();
		f1.setCodigo(1);
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			fdao.excluir(f1);
			System.out.println("Deletado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar!");
			e.printStackTrace();
		}
		
		Fornecedores f1 = new Fornecedores();
		f1.setCodigo(3);
		f1.setDescricao("Helinton");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			fdao.editar(f1);
			System.out.println("Alterado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao fazer a alteração!");
			e.printStackTrace();
		}
		
		Fornecedores f1 = new Fornecedores();
		f1.setCodigo(4);
		
		Fornecedores f2 = new Fornecedores();
		f2.setCodigo(8);
		
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Fornecedores f3 = fdao.buscaPorCodigo(f1);
			Fornecedores f4 = fdao.buscaPorCodigo(f2);
			
			System.out.println("Resultado 1: " + f3);
			System.out.println("Resultado 2: " + f4);
			
		}catch(SQLException e){
			System.out.println("Fornecedor não encontrado");
			e.printStackTrace();
		}
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			ArrayList<Fornecedores> lista = fdao.listar();
			
			for(Fornecedores f : lista){
				System.out.println("Fornecedor: " + f);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar");
			e.printStackTrace();
			
		}*/
		
		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("Heli");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {
			
			DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
			ArrayList<Fornecedores> lista = fdao.buscarPorDescricao(f1) ;
			
			for(Fornecedores f : lista){
				System.out.println("Resultado " + f);
			}		
			
		} catch (Exception e) {
			System.out.println("Erro ao buscar descrição");
			e.printStackTrace();
		}

		
	}		
		
}
