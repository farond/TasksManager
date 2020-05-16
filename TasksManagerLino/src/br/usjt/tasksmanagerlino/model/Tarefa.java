package br.usjt.tasksmanagerlino.model;

public class Tarefa implements java.io.Serializable {

private static final long serialVersionUID = 1L;
	
	private int id;
	private String titulo;
	private String descricao;
	private String emailUsuario;
	
	public Tarefa(int id, String titulo, String descricao, String emailUsuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.emailUsuario = emailUsuario;
	}
	
	public Tarefa(String titulo, String descricao, String emailUsuario) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.emailUsuario = emailUsuario;
	}
	
	public Tarefa() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
}