package br.usjt.tasksmanagerlino.model;

public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
	private String nome;

	public Usuario() {}
	
	public Usuario (String email, String senha, String nome) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
