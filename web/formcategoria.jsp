
<%@page import="Aplicacao.Categoria"%>
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
        
        else if(!usuario.getTipo().equals("2")){
        
        response.sendRedirect("index.jsp");
        
        }
 
%>
        
        <div class="container mt-2">
          
            
            <%
               Categoria aux = (Categoria)request.getAttribute("categoria");
            %>
            <div class="col-6 mt-5">
                  <h4>Incluir Categoria</h4>
                  <form method="POST" action="CategoriaController" >
                      <input type="hidden" class="form-control" name="id" value="<%= aux.getIdcategoria() %>">
                      
                    <div class="form-group">
                        <label for="Razao Social">Categoria</label>
                        <input type="text" class="form-control" name="nome_categoria" value="<%= aux.getNome_categoria() %>" maxlength="50" placeholder="O nome da categoria">
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Enviar</button>
                    <a href="CategoriaController?acao=mostrar" class="btn btn-outline-danger">Retornar</a>
                </form>
            </div>
        </div>
    </body>
</html>

