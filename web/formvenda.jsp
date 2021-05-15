
<%@page import="java.util.*"%>
<%@page import="Aplicacao.Cliente"%>
<%@page import="Aplicacao.Produto"%>
<%@page import="Aplicacao.Usuario"%>
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
               Produto aux = (Produto)request.getAttribute("produto");
               
            %>
            <%
               Venda vendaaux = (Venda)request.getAttribute("venda");
            %>
            
            <div class="col-6 mt-5">
                  <h4>Realizar Venda</h4>
                  <form method="POST" action="VendaController" >
                      <input type="hidden" class="form-control" name="id" value="<%=vendaaux.getIdvenda()%>">            
                      
                    <div class="form-group ">
                        <label for="Nome">Nome</label>
                        <input type="text" class="form-control" name="nomeproduto" value="<%= aux.getNome_produto() %>" maxlength="100" placeholder="Nome do produto" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label for="Descricao">Descrição</label>
                        <input type="text" class="form-control"  name="descricao" value="<%= aux.getDescricao() %>" placeholder="Descrição do produto" readonly="readonly">
                    </div>                    
                    <div class="form-group">
                        <label for="QuantidadeEstoque">Quantidade em estoque</label>
                        <input type="text" class="form-control"  name="quantidadeestoque" value="<%= aux.getQuantidade_disponivel() %>" placeholder="Quantidade disponível" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label for="QuantidadeDesejada">Quantidade desejada</label>
                        <input type="number" class="form-control"  name="quantidadedesejada" value="1" placeholder="Quantidade de produtos desejada">
                    </div>
                    <div class="form-group">
                        <label for="Preco">Preço</label>
                        <input type="number" class="form-control"  name="preco" value="<%= aux.getPreco_venda() %>" placeholder="Preço do produto"" >
                    </div>                                    
                    
                    <div class="form-group">
                        <h4>Selecionar Cliente</h4>
                        
                        <%
                            ArrayList<Cliente> ListaCliente = (ArrayList<Cliente>) request.getAttribute("meusClientes");
                            for (int i = 0; i < ListaCliente.size(); i++) {
                                Cliente cliente = ListaCliente.get(i);

                         %>
                        
                           <input type="radio" name="idcliente" id="idcliente" value="<%=cliente.getIdcliente() %>"> <%=cliente.getNome() %><br>
                       
                        
                         <%
                            }
                         %> 
                         
                         
                     
                    </div>
                    
                     <div class="form-group">
                        <label for="vendedor">Vendedor</label>
                        <input type="hidden" class="form-control" name="idproduto" value="<%= aux.getIdproduto() %>">
                        <input type="hidden" class="form-control" name="idvendedor" value="<%= usuario.getIdusuario() %>">
                        <input type="text" class="form-control"  name="nomevendedor" value="<%= usuario.getNome() %>" readonly="readonly">
                    </div>
                    
                    
                    
                    
                   
                    <button type="submit" class="btn btn-primary">Vender</button>
                    <a href="ProdutoController?acao=mostrar" class="btn btn-outline-danger">Retornar</a>
                </form>
            </div>
        </div>
    </body>
</html>
