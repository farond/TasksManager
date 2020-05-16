package br.usjt.tasksmanagerlino.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.tasksmanagerlino.model.Tarefa;
import br.usjt.tasksmanagerlino.service.TarefaService;


@WebServlet("/DeletarTarefa.do")
public class ExcluirTarefaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirTarefaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String idTarefa = request.getParameter("id");
		TarefaService ts = new TarefaService();

		int idTarefaInt = Integer.parseInt(idTarefa);
		Tarefa t = ts.consultar(idTarefaInt);

		ts.excluir(t);
		
		response.sendRedirect("tarefas.jsp");
	}
}
