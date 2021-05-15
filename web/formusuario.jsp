
<%@page import="Aplicacao.Usuario"%>
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
         
        <!-- Cabeçalho -->
        <%@include file="cabecalho.jsp" %><!-- Inclusão do cabeçalho -->
        
        <%
        
        if(usuario.isIsValid()==false){
        
        response.sendRedirect("index.jsp");
        
        }
        
        else if(!usuario.getTipo().equals("0")){
        
        response.sendRedirect("index.jsp");
        
        }
 
%>
             
        
        <div class="container mt-2">
          
            
            <%
               Usuario aux = (Usuario)request.getAttribute("usuario");
            %>
            <div class="col-6 mt-5">
                  <h4>Incluir Usuario</h4>
                  <form method="POST" action="UsuarioController" >
                      <input type="hidden" class="form-control" name="id" value="<%= aux.getIdusuario() %>">
                      <input type="hidden" class="form-control" name="tipo" value="<%= aux.getTipo() %>">
                      
                    <div class="form-group">
                        <label for="Nome">Nome</label>
                        <input type="text" class="form-control" name="nome" value="<%= aux.getNome() %>" required size="30" maxlength="100" placeholder="Seu Nome">
                    </div>
                    <div class="form-group">
                        <label for="CPF">CPF</label>
                        <input type="text" class="form-control"  name="cpf" value="<%= aux.getCpf() %>" required size="14" placeholder="Seu CPF">
                    </div> 
                    <div class="form-group">
                        <label for="Senha">Senha</label>
                        <input type="text" class="form-control"  name="senha" value="<%= aux.getSenha() %>" placeholder="Sua Senha">
                    </div>
                    <div class="form-group">
                        <label for="tipo">Tipo de permissão</label>
                        <input type="text" class="form-control"  name="tipo" value="<%= aux.getTipo() %>" placeholder="Sua Permissão" readonly="readonly">
                    </div>
              
                    
                    
                    <button type="submit" class="btn btn-primary">Enviar</button>
                    <a href="paginausuarioinicial.jsp" class="btn btn-outline-danger">Retornar</a>
                </form>
            </div>
        </div>
    </body>
</html>
