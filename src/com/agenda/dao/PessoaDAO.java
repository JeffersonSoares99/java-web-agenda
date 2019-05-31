package com.agenda.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.agenda.model.Pessoa;
import com.agenda.util.ConnectionFactory;
import com.mysql.jdbc.Connection;

public class PessoaDAO {
	
	private Connection connection;
	private PreparedStatement stmt;
	
	public PessoaDAO() {
	}
	
	public void cadastro(Pessoa pessoa) {
		
		String SQL = "insert into pessoa (nome, email, endereco, telefone) values (?,?,?,?)";
		
		try {
			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);
			
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getEndereco());
			stmt.setString(4, pessoa.getTelefone());
			
			stmt.execute();
			stmt.close();
			
			buscaPessoas();
			
		
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
		
		public List<Pessoa> buscaPessoas(){
			
			String SQL = "select * from pessoa"; 
			
			try {
				
				this.connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = this.connection.prepareStatement(SQL);
				
				List<Pessoa> pessoas = new ArrayList<Pessoa>();
				
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					Pessoa pessoa = new Pessoa();
					pessoa.setId(rs.getLong("id"));
					pessoa.setNome(rs.getString("nome"));
					pessoa.setEmail(rs.getString("email"));
					pessoa.setEndereco(rs.getString("endereco"));
					pessoa.setTelefone(rs.getString("telefone"));
					pessoas.add(pessoa);
					
				}
				
				stmt.close();
				this.connection.close();
				
				System.out.println(pessoas);
				
				return pessoas;
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void removerContato(Pessoa pessoa) {
			String SQL = "delete from pessoa where id=?";
			
			try {
				
				this.connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = this.connection.prepareStatement(SQL);
				stmt.setLong(1, pessoa.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
				
			
					
			}	
			
		}
		
		public void alterar (Pessoa pessoa){
			
			String SQL = "update pessoa set "
					+ "nome=?, "
					+ "email=?, "
					+ "endereco=?, "
					+ "telefone=? "
					+ " where id=?";
			
			
try {
				
				this.connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = this.connection.prepareStatement(SQL);
				
				stmt.setString(1, pessoa.getNome());
				stmt.setString(2, pessoa.getEmail());
				stmt.setString(3, pessoa.getEndereco());
				stmt.setString(4, pessoa.getTelefone());
				stmt.setLong(5, pessoa.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				
				throw new RuntimeException(e);
				
			
					
			}	
			
					
		}
		
		
	}


