package br.usjt.tasksmanagerlino.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(); 
		
		sessao.removeAttribute("email");
		sessao.removeAttribute("senha");
		sessao.removeAttribute("nome");
		sessao.invalidate();
		response.sendRedirect("index.jsp");
	
	}

}
