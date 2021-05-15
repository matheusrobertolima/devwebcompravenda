
<%@page import="Aplicacao.Compra"%>
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
               Compra aux = (Compra)request.getAttribute("compra");
            %>
            <div class="col-6 mt-5">
                  <h4>Editar Compra</h4>
                  <form method="POST" action="CompraUpdate" >
                      <input type="hidden" class="form-control" name="id" value="<%= aux.getIdcompra() %>">
                      
                    <div class="form-group">
                        <label for="Quantidade Adquirida">Quantidade Adquirida</label>
                        <input type="number" class="form-control" name="quantidadedesejada" value="<%= aux.getQuantidadecompra() %>" placeholder="Quantidade desejada">
                    </div>
                    <div class="form-group">
                        <label for="Valor">Valor</label>
                        <input type="number" class="form-control" name="preco" value="<%= aux.getValorcompra() %>" placeholder="Valor do produto">
                    </div>
                    <div class="form-group">
                        <label for="Id Fornecedor">Id Fornecedor</label>
                        <input type="number" class="form-control" name="idfornecedor" value="<%= aux.getIdfornecedor() %>" placeholder="Id do fornecedor" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label for="Id Produto">Id Produto</label>
                        <input type="number" class="form-control" name="idproduto" value="<%= aux.getIdproduto() %>" placeholder="Id do produto" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label for="Id Vendedor">Id Comprador</label>
                        <input type="number" class="form-control" name="idcomprador" value="<%= aux.getIdcomprador() %>" placeholder="Id do comprador" readonly="readonly">
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Enviar</button>
                    <a href="CompraController?acao=mostrar" class="btn btn-outline-danger">Retornar</a>
                </form>
            </div>
        </div>
    </body>
</html>

