<%@ page import="java.util.*" %>
<%@ page import="Aplicacao.Produto" %>

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

    
            <h1>Relatório do Estoque Disponível</h1>     
            <p></p>
            <p></p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Produto</th>
                            <th scope="col">Quantidade disponível</th>


                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            ArrayList<Produto> ListaProduto = (ArrayList<Produto>) request.getAttribute("meusProdutos");
                            for (int i = 0; i < ListaProduto.size(); i++) {
                                Produto aux = ListaProduto.get(i);

                         %>
                        <tr>
                            <td><%=aux.getIdproduto() %></td>
                            <td><%=aux.getNome_produto() %></td> 
                            <td><%=aux.getQuantidade_disponivel() %></td> 
 
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