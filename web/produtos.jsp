<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Aplicacao.Produto" %>
<%@ page import="Aplicacao.Usuario" %>
<%@ page import="Aplicacao.Categoria" %>

<!DOCTYPE html>
<html lang="pt-br">
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

<!--- Produtos -->

<div class="container-fluid padding">
<div class="row welcome text-center">
	<div class="col-12">
		<h1 class="display-4">Produtos</h1>
	</div>
	<hr>
</div>
</div>

        <div class="container mt-2">
       
            <p></p>
        
            <p></p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                          
                            <th scope="col">Nome</th>
                            <th scope="col">Descrição</th>
                  
                            <th scope="col">Preço</th> 
                            <th scope="col">Categoria</th> 
                            <th scope="col">Quantidade disponível</th>
                            
                            <% if(usuario.isIsValid()==true) { %>
                            
                            <% if(usuario.getTipo().equals("1")) { %>
                            
                            <th scope="col"><div class="float-right">Ações</div><br></th>
                            
                            <% } %>
                            
                            <% if(usuario.getTipo().equals("2")) { %>
                            
                            <th scope="col"><div class="float-right">Ações</div><br></th>
                            
                            <% } %>
                            <% } %>
                            
                                   
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            
                            ArrayList<Produto> ListaProduto = (ArrayList<Produto>) request.getAttribute("meusProdutos");
                            ArrayList<Categoria> ListaCategoria = (ArrayList<Categoria>) request.getAttribute("minhasCategorias");
                            for (int i = 0; i < ListaProduto.size(); i++) {
                                Produto aux = ListaProduto.get(i);
                                
                                      
   
                                String nomectg = "";
                                String link_vender = "VendaController?acao=venderproduto&id="+aux.getIdproduto();
                                String link_comprar = "CompraController?acao=comprarproduto&id="+aux.getIdproduto();
                                
                                for(int x = 0; x < ListaCategoria.size();x++){                               
                                Categoria ctg = ListaCategoria.get(x);
                                
                                    if(aux.getId_categoria()==ctg.getIdcategoria()){
                                    
                                    nomectg = ctg.getNome_categoria();
                                    }
                                }
                               
                                
                            if (aux.getLiberado_venda().equals("S") && aux.getQuantidade_disponivel() > 0) { %>
                                 
                              <tr>
                            
                            <td><%=aux.getNome_produto()%></td> 
                            <td><%=aux.getDescricao()%></td> 
                            <% if(usuario.isIsValid()==true) { %>
                            <% if(usuario.getTipo().equals("2")) { %>
                            
                            <td><%=aux.getPreco_compra()%></td> 
                            
                            <% } else { %>
                                
                            <td><%=aux.getPreco_venda()%></td> 
                            
                            <% } %>
                            <% } else { %>
                            <td><%=aux.getPreco_venda()%></td>     
                            <% } %>
                            <td><%=nomectg %></td> 
                            <td><%=aux.getQuantidade_disponivel()%></td> 
                            <% if(usuario.isIsValid()==true) { %>
                            
                            <% if(usuario.getTipo().equals("1")) { %>
                            
                            <td><a href="<%=link_vender%>" class="btn btn-outline-secondary float-right">Vender</a>
                            
                            <% } %>
                            
                            <% if(usuario.getTipo().equals("2")) { %>
                            
                            <td><a href="<%=link_comprar%>" class="btn btn-outline-secondary float-right">Comprar</a>
                            
                            <% } %>
                            <% } %>
                            

                            </tr> 
                       
                        <%
                           } 

                           

                           } 
                        %> 
                        
                 
                              
                    </tbody>
                </table>
            </div>
        </div>

<hr class="my-4">

<!--- Footer -->

<jsp:include page="footer.jsp" />


</body>
</html>