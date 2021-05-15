<%@ page import="java.util.*" %>
<%@ page import="Aplicacao.Compra" %>

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

    
            <h1>Lista de Compras Realizadas Pelo Comprador <%=usuario.getNome()%></h1>     
            <p></p>
            
            <p></p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Quantidade Adquirida</th>
                            <th scope="col">Data</th>
                            <th scope="col">Valor</th>
                            <th scope="col">Id Fornecedor</th> 
                            <th scope="col">Id Produto</th>
                            <th scope="col">Id Comprador</th>
                            <th scope="col"><div class="float-right">Ações</div><br></th>
                            
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            ArrayList<Compra> ListaCompra = (ArrayList<Compra>) request.getAttribute("minhasCompras");
                            for (int i = 0; i < ListaCompra.size(); i++) {
                                Compra aux = ListaCompra.get(i);
                                String link_editar = "CompraController?acao=editar&id="+aux.getIdcompra();
                                String link_excluir = "CompraController?acao=excluir&id="+aux.getIdcompra(); 
                         %>
                        <tr>
                            <% if(usuario.getIdusuario()==aux.getIdcomprador()) {  %>
                            <td><%=aux.getIdcompra()%></td>
                            <td><%=aux.getQuantidadecompra()%></td> 
                            <td><%=aux.getDatacompra()%></td> 
                            <td><%=aux.getValorcompra()%></td>
                            <td><%=aux.getIdfornecedor()%></td> 
                            <td><%=aux.getIdproduto()%></td> 
                            <td><%=aux.getIdcomprador()%></td>
                            <td><a href="<%=link_excluir%>" class="btn btn-outline-danger float-right">Excluir</a> <a href="<%=link_editar%>" class="btn btn-outline-secondary float-right">Editar</a> 
                            </td> 
                            <% } %>
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
