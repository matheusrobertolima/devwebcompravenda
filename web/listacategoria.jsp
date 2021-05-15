<%@ page import="java.util.*" %>
<%@ page import="Aplicacao.Categoria" %>

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

    
            <h1>Lista de Categorias</h1>     
            <p></p>
            <a href="CategoriaController?acao=incluir" class="btn btn-outline-primary">Cadastrar Nova Categoria</a>
            <p></p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome da Categoria</th>

                            <th scope="col"><div class="float-right">Ações</div><br></th>
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            ArrayList<Categoria> ListaCategoria = (ArrayList<Categoria>) request.getAttribute("minhasCategorias");
                            for (int i = 0; i < ListaCategoria.size(); i++) {
                                Categoria aux = ListaCategoria.get(i);
                                String link_editar = "CategoriaController?acao=editar&id="+aux.getIdcategoria();
                                String link_excluir = "CategoriaController?acao=excluir&id="+aux.getIdcategoria(); 
                         %>
                        <tr>
                            <td><%=aux.getIdcategoria()%></td>
                            <td><%=aux.getNome_categoria()%></td> 

                            <td><a href="<%=link_excluir%>" class="btn btn-outline-danger float-right">Excluir</a> <a href="<%=link_editar%>" class="btn btn-outline-secondary float-right">Editar</a> 
                            </td> 
                           
                        </tr>
                        <%
                            }
                        %>  
                    </tbody>
                </table>
            </div>
        </div>
              
    </body>
</html>