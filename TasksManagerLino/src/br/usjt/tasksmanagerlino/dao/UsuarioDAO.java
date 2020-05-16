package br.usjt.tasksmanagerlino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.tasksmanagerlino.connection.ConnectionFactory;
import br.usjt.tasksmanagerlino.model.Usuario;


public class UsuarioDAO {
	private Connection conexao;

	public UsuarioDAO() {
		new ConnectionFactory();
		this.conexao = ConnectionFactory.conectar();
	}

	// Autentificação do Usuario
	public Usuario consultar(String email, String senha) {
		
		String consultar = "SELECT * FROM usuario "
				+ " WHERE email = ? AND senha = ?";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setString(1, email);
			pst.setString(2, senha);
			ResultSet resultado = pst.executeQuery();
			
			Usuario u = new Usuario();
			if (resultado.next()) {
				u.setEmail(resultado.getString("email"));
				u.setSenha(resultado.getString("senha"));
				u.setNome(resultado.getString("nome"));
			}
			return u;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela usuario.");
			ex.printStackTrace();
			
			return null;
		}
	}

	// Cadastro do Usuario
	public void cadastrar(Usuario usuario) {

		String inserir = "INSERT INTO usuario (email, senha, nome) VALUES (?, ?, ?) ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getSenha());
			pst.setString(3, usuario.getNome());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular a tabela Usuario.");
			ex.printStackTrace();

		}
	}

}
