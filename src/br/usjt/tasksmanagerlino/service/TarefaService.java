package br.usjt.tasksmanagerlino.service;

import java.util.ArrayList;

import br.usjt.tasksmanagerlino.dao.TarefaDAO;
import br.usjt.tasksmanagerlino.model.Tarefa;

public class TarefaService {
	private TarefaDAO tarefaDao;
	
	public TarefaService() {
		this.tarefaDao = new TarefaDAO();
	}
	
	public void cadastrar(Tarefa tarefa) {
		this.tarefaDao.cadastrar(tarefa);
	}
	
	public void alterar(Tarefa tarefa) {
		this.tarefaDao.alterar(tarefa);
	}
	
	public void excluir(Tarefa tarefa) {
		this.tarefaDao.excluir(tarefa);
	}
	
	public Tarefa consultar(int id) {
		return this.tarefaDao.consultar(id);
	}
	
	public ArrayList<Tarefa> listar(String emailUsuario) {
		return this.tarefaDao.listar(emailUsuario);
	}
}