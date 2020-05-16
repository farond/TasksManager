package br.usjt.tasksmanagerlino.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.tasksmanagerlino.model.Tarefa;
import br.usjt.tasksmanagerlino.service.TarefaService;


@WebServlet( "/AlterarTarefa.do")
public class EditarTarefaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarTarefaController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		String idTarefa = request.getParameter("id_tarefa");
		String titulo = request.getParameter("titulo_tarefa");
		String descricao = request.getParameter("descricao_tarefa");
		String emailUsuario = request.getParameter("email_usuario_tarefa");

		int idTarefaInt = Integer.parseInt(idTarefa);
		Tarefa t = new Tarefa(idTarefaInt, titulo, descricao, emailUsuario);
		TarefaService ts = new TarefaService();
		//ts.alterar(t);
		//response.sendRedirect("tarefas.jsp");
		
		if(titulo.equals("") || descricao.equals("") || emailUsuario.equals("")) {			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("mensagem", " Preencha todos os campos");
			response.sendRedirect("alterar_tarefa.jsp");
		}
		else {	
			ts.alterar(t);
			HttpSession sessao = request.getSession();
			sessao.setAttribute("mensagem", " Alteração efetuada com sucesso");
			response.sendRedirect("tarefas.jsp");
		}
	}
	
}
