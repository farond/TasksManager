<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	String email = "";
	HttpSession sessao = request.getSession();
	if (session.getAttribute("nome") == null || session.getAttribute("email") == null) {
		session.setAttribute("mensagem", "Por favor faça o login!");
		response.sendRedirect("index.jsp");
	} else {
		nome = (String) session.getAttribute("nome");
		email = (String) session.getAttribute("email");
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

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
				<form class="login100-form validate-form flex-sb flex-w"
					method="post" action="CadastrarTarefa.do">
					<span class="login100-form-title p-b-51"> Adicionar Tarefa </span>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Titulo é obrigatório">
						<input class="input100" type="text" name="titulo_tarefa"
							placeholder="Titulo da Tarefa"> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Descrição é obrigatório">
						<input class="input100" type="text" name="descricao_tarefa"
							placeholder="Descrição da Tarefa"> <span
							class="focus-input100"></span>
					</div>

					<input type="hidden" name="email_usuario_tarefa"
						value="<%=email%>" />
					<div class="container-login100-form-btn m-t-17">
						<button type="submit" class="login100-form-btn">
							Adicionar</button>
							
					</div>
					<% 	if(session.getAttribute("mensagem") != null) {		%>
								<div>
									<p >
									<%= session.getAttribute("mensagem") %>
									</p>										
								</div>
								
							<%
							session.removeAttribute("mensagem");		}
							%>
				</form>
				<div class="login100-more" style="background-image: url('images/5898.png');"></div>
			</div>
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