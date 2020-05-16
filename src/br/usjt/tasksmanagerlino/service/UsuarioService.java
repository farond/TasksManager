package br.usjt.tasksmanagerlino.service;

import br.usjt.tasksmanagerlino.dao.UsuarioDAO;
import br.usjt.tasksmanagerlino.model.Usuario;

public class UsuarioService {
	
	private UsuarioDAO usuarioDao;


	public UsuarioService(){
		this.usuarioDao = new UsuarioDAO();
	}

	public Usuario consultar(String email, String senha) {		
		return usuarioDao.consultar(email, senha);
	
	}

	public void cadastraUsuario(Usuario usuario) {
		usuarioDao.cadastrar(usuario);
	}


}
