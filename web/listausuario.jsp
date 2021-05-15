<%@ page import="java.util.*" %>
<%@ page import="Aplicacao.Usuario"%>

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

            
            <h1>Lista de <%= request.getAttribute("tipo") %></h1>     
            <p></p>
            <a href="UsuarioController?acao=incluir<%= request.getAttribute("tipo") %>" class="btn btn-outline-primary">Cadastrar novo <%= request.getAttribute("tipo") %></a>
            <p></p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col">CPF</th>
                            <th scope="col">Senha</th>
                            <th scope="col">Tipo</th>                             
                            <th scope="col"><div class="float-right">Ações</div><br></th>
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            ArrayList<Usuario> ListaUsuario = (ArrayList<Usuario>) request.getAttribute("meusUsuarios");
                            for (int i = 0; i < ListaUsuario.size(); i++) {
                                Usuario aux = ListaUsuario.get(i);
                                
                                String link_editar = "UsuarioController?acao=editar&id="+aux.getIdusuario();
                                String link_excluir = "UsuarioController?acao=excluir&id="+aux.getIdusuario(); 
                         %>
                        <tr>
                            <td><%=aux.getIdusuario()%></td>
                            <td><%=aux.getNome()%></td> 
                            <td><%=aux.getCpf()%></td> 
                            <td><%=aux.getSenha()%></td>
                            <td><%=aux.getTipo()%></td> 
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
