
<%@page import="Aplicacao.Venda"%>
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
        
        else if(!usuario.getTipo().equals("1")){
        
        response.sendRedirect("index.jsp");
        
        }
 
%>
        
        <div class="container mt-2">
          
            
            <%
               Venda aux = (Venda)request.getAttribute("venda");
            %>
            <div class="col-6 mt-5">
                  <h4>Editar Venda</h4>
                  <form method="POST" action="VendaUpdate" >
                      <input type="hidden" class="form-control" name="id" value="<%= aux.getIdvenda() %>">
                      
                    <div class="form-group">
                        <label for="Quantidade Vendida">Quantidade Vendida</label>
                        <input type="number" class="form-control" name="quantidadedesejada" value="<%= aux.getQuantidadevenda() %>" placeholder="Quantidade desejada">
                    </div>
                    <div class="form-group">
                        <label for="Valor">Valor</label>
                        <input type="number" class="form-control" name="preco" value="<%= aux.getValorvenda() %>" placeholder="Valor do produto">
                    </div>
                    <div class="form-group">
                        <label for="Id Cliente">Id Cliente</label>
                        <input type="number" class="form-control" name="idcliente" value="<%= aux.getIdcliente() %>" placeholder="Id do cliente" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label for="Id Produto">Id Produto</label>
                        <input type="number" class="form-control" name="idproduto" value="<%= aux.getIdproduto() %>" placeholder="Id do produto" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label for="Id Vendedor">Id Vendedor</label>
                        <input type="number" class="form-control" name="idvendedor" value="<%= aux.getIdvendedor() %>" placeholder="Id do vendedor" readonly="readonly">
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Enviar</button>
                    <a href="VendaController?acao=mostrar" class="btn btn-outline-danger">Retornar</a>
                </form>
            </div>
        </div>
    </body>
</html>

