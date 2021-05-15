<%@ page import="java.util.*" %>
<%@ page import="Aplicacao.Venda" %>

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

    
            <h1>Relatório das Vendas</h1>     
            <p></p>
            
            <p></p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Quantidade Vendida</th>
                            <th scope="col">Data</th>
                            <th scope="col">Valor</th>
                            <th scope="col">Id Cliente</th> 
                            <th scope="col">Id Produto</th>
                            <th scope="col">Id Vendedor</th>
                            
                            
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            ArrayList<Venda> ListaVenda = (ArrayList<Venda>) request.getAttribute("minhasVendas");
                            for (int i = 0; i < ListaVenda.size(); i++) {
                                Venda aux = ListaVenda.get(i);
                                
                         %>
                        <tr>
                           
                            <td><%=aux.getIdvenda()%></td>
                            <td><%=aux.getQuantidadevenda()%></td> 
                            <td><%=aux.getDatavenda()%></td> 
                            <td><%=aux.getValorvenda()%></td>
                            <td><%=aux.getIdcliente()%></td> 
                            <td><%=aux.getIdproduto()%></td> 
                            <td><%=aux.getIdvendedor()%></td>
                            
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
