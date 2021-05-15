<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Européias.com</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/fa/all.js"></script>
        <script src="js/jquery.validate.min.js"></script>

  

	<link href="css/style.css" rel="stylesheet">
	<link href="css/login.css" rel="stylesheet">
</head>

<body>
  
<!-- Cabeçalho -->
<%@include file="cabecalho.jsp" %><!-- Inclusão do cabeçalho -->
        
        <%
        
        if(usuario.isIsValid()==true){
        
        response.sendRedirect("index.jsp");
        
        }
              
 
%>


  <div class="container" >
     
    <div class="content">      
      <!--FORMULÁRIO DE LOGIN-->
      <div id="login">
        <form method="post" action="FazerLogin" id="formlogin"> 
          <div id="header"></div>

          <h1>Login</h1> 

          <p>
            <label for="cpf_login">CPF</label>
            <input id="cpf_login" class="form-control cpf" name="cpf_login" type="text" placeholder="ex. 123.456.789-0"
          </p>

          <p>
            <label for="senha_login">Senha</label>
            <input id="senha_login" name="senha_login"  type="password" placeholder="ex. senha"/>
          </p>
           
          <p> 
            <input type="checkbox" name="manterlogado" id="manterlogado" value="" /> 
            <label for="manterlogado">Manter-me logado</label>
          </p>
           
          <p> 
            <input type="submit" value="Entrar" /> 
          </p>
           
         
        </form>
      </div>
    </div>
  </div>  


        <script src="js/jquery.mask.min.js"></script>

	<script>
		$(document).ready(function(){
		   $('.cpf').mask('000.000.000-00', {reverse: true});
		});
	</script>
 
</body>
</html>