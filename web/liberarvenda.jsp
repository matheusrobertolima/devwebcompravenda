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
        
        else if(usuario.getTipo().equals("1")|| usuario.getTipo().equals(null)){
        
        response.sendRedirect("index.jsp");
        
        }
 
%>
   
        
        <div class="container mt-2">

    
            <h1>Lista de Produtos</h1>     
            <p></p>           
            <p></p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Descrição</th>
                            <th scope="col">Preço de Compra</th>
                            <th scope="col">Preço de Venda</th> 
                            <th scope="col">Quantidade disponível</th>
                            <th scope="col">Liberado para a venda?</th>
                            <th scope="col">Id Categoria</th>
                            <th scope="col"><div class="float-right">Ações</div><br></th>
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            ArrayList<Produto> ListaProduto = (ArrayList<Produto>) request.getAttribute("meusProdutos");
                            for (int i = 0; i < ListaProduto.size(); i++) {
                                Produto aux = ListaProduto.get(i);
                                String link_liberar = "ProdutoController?acao=liberar&id="+aux.getIdproduto();
                                String link_bloquear = "ProdutoController?acao=bloquear&id="+aux.getIdproduto(); 
                         %>
                        <tr>
                            <td><%=aux.getIdproduto()%></td>
                            <td><%=aux.getNome_produto()%></td> 
                            <td><%=aux.getDescricao()%></td> 
                            <td><%=aux.getPreco_compra()%></td>
                            <td><%=aux.getPreco_venda()%></td> 
                            <td><%=aux.getQuantidade_disponivel()%></td> 
                            <td><%=aux.getLiberado_venda()%></td>
                            <td><%=aux.getId_categoria()%></td> 
                            <td><a href="<%=link_bloquear%>" class="btn btn-outline-danger float-right">Bloquear venda</a> <a href="<%=link_liberar%>" class="btn btn-outline-secondary float-right">Liberar venda</a> 
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
