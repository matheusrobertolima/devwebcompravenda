
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Européias.com</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/fa/all.js"></script>
	<link href="css/style.css" rel="stylesheet">
    </head>
 
    <body>
        
         <jsp:useBean id="usuario" class="Aplicacao.Usuario" scope="session">
</jsp:useBean>
        
        <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
        <div class="container-fluid">
	<a class="navbar-brand" href="index.jsp"><img src="img/logo.png"></a> <!-- LOGO DO SITE -->
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
		<span class="navbar-toggler-icon"></span> <!-- menu -->
	</button>

	<div class="collapse navbar-collapse" id="navbarResponsive"> <!-- MENU -->
		<ul class="navbar-nav ml-auto">  <!-- Menu de navegação para a direita -->
			<li class="nav-item active">
				<a class="nav-link" href="index.jsp">Home</a>
			</li>

			<li class="nav-item">
				<a class="nav-link" href="ProdutoController?acao=mostrar">Produtos</a>
			</li>
                        <% if(usuario.isIsValid()== true){ %>
                        
                        <li class="nav-item">
                            
                            <a class="nav-link" href="paginausuarioinicial.jsp">Área privada</a>                        
                            
			</li>
                        
                        <li class="nav-item">
                            
                            <a class="nav-link" href="LogoutServlet">Sair</a>                        
                            
			</li>
                        <%} else{ %>
                        <li class="nav-item">
                            
                            <a class="nav-link" href="login.jsp">Login</a>
                                                  
			</li>
                         <% } %>
                        

		</ul>
	</div>
        
</div>	
</nav>
        
        
    </body>
</html>


