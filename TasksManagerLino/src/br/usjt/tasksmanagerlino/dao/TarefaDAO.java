package br.usjt.tasksmanagerlino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.usjt.tasksmanagerlino.connection.ConnectionFactory;
import br.usjt.tasksmanagerlino.model.Tarefa;

public class TarefaDAO {
private Connection conexao;
	
	public TarefaDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Tarefa tarefa) {
			
		String inserir = "INSERT INTO tarefas "
				+ " (titulo, descricao, fk_usuario_email) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, tarefa.getTitulo());
			pst.setString(2, tarefa.getDescricao());
			pst.setString(3, tarefa.getEmailUsuario());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela tarefa.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Tarefa tarefa) {
		
		String alterar = "UPDATE tarefas "
				+ "SET titulo = ?, descricao = ?, fk_usuario_email = ? "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(alterar) ) {
			
			pst.setString(1, tarefa.getTitulo());
			pst.setString(2, tarefa.getDescricao());
			pst.setString(3, tarefa.getEmailUsuario());
			pst.setInt(4, tarefa.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela tarefa.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Tarefa tarefa) {
		
		String excluir = "DELETE FROM tarefas "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(excluir) ) {
			
			pst.setInt(1, tarefa.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela tarefa.");
			ex.printStackTrace();
		}
	}
	
	public Tarefa consultar(int id) {
		String consultar = "SELECT * FROM tarefas "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Tarefa n = new Tarefa();
			if (resultado.next()) {
				n.setId(id);
				n.setTitulo(resultado.getString("titulo"));
				n.setDescricao(resultado.getString("descricao"));
				n.setEmailUsuario(resultado.getString("fk_usuario_email"));
			}
			return n;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela tarefa.");
			ex.printStackTrace();
			
			return null;
		}
	}
	
	public ArrayList<Tarefa> listar(String emailUsuario) {
		String consultar = "SELECT * FROM tarefas WHERE fk_usuario_email = ?";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setString(1, emailUsuario);
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Tarefa> lista = new ArrayList<>();
			while (resultado.next()) {
				Tarefa t = new Tarefa();
				t.setId(resultado.getInt("id"));
				t.setTitulo(resultado.getString("titulo"));
				t.setDescricao(resultado.getString("descricao"));
				t.setEmailUsuario(resultado.getString("fk_usuario_email"));
				lista.add(t);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela tarefas.");
			ex.printStackTrace();
			
			return null;
		}
	}


}
