<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.usjt.tasksmanagerlino.model.Tarefa"%>
<%@ page import="br.usjt.tasksmanagerlino.service.TarefaService"%>
<!DOCTYPE html>
<html>
<head>
<title>Task Manager</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/principal.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<%
		String nome = "";
	HttpSession sessao = request.getSession();
	if (session.getAttribute("nome") == null) {
		session.setAttribute("mensagem", "Por favor faça o login!");
		response.sendRedirect("index.jsp");
	} else {
		nome = (String) session.getAttribute("nome");

	}
	%>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="tarefas.jsp">Task Manager</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="cadastrar_tarefa.jsp">Adicionar tarefa</a></li>
			</ul>
			<div>
				<h5>Olá, <%=nome%></h5>
				<a href="logout.do" class="txt1">Sair</a>				
			</div>
		</div>
	</nav>
	<div style="margin-top: 25px;" class="container">
		<div class="row-2 row-cols-1 row-cols-lg-3">
			<%
				String email = (String) session.getAttribute("email");
			TarefaService ts = new TarefaService();
			Tarefa t = new Tarefa();
			ArrayList<Tarefa> lista = new ArrayList<>();
			lista = ts.listar(email);
			if (lista.size() >= 1) {
				for (int i = 0; i < lista.size(); i++) {
					t = lista.get(i);
			%>
		
			<div class="col mb-4">
				<div class="card h-100">
					<div class="card-body">
						<h5 class="card-title"><%=t.getTitulo()%></h5>
						<p class="card-text"><%=t.getDescricao()%></p>
						<a href="DeletarTarefa.do?id=<%=t.getId()%>"
							class="card-link txt1">Deletar</a> 
						<a href="alterar_tarefa.jsp?id=<%=t.getId()%>"
							class="card-link txt1">Alterar</a>
					</div>
				</div>
			</div>
		
			<%
				}
			}
			%>
		</div>
	</div>


	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>
</body>
</html>