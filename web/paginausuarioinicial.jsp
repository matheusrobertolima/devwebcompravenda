<%@ page import="java.util.*" %>
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
        
    
   
     <div class="container mt-2">
         
         <% 
    
    if(usuario.isIsValid()==false){
    
    response.sendRedirect("index.jsp");
    
    } else if(usuario.getTipo().equals("0")) { %>
    
    <h5>Bem vindo, administrador <%= usuario.getNome()%></h5>
            
                        <li class="nav-item">
                            
                            <a class="nav-link" href="UsuarioController?acao=mostraradministrador">Lista de Administradores</a>  
                        <li class="nav-item">
                            
                            <a class="nav-link" href="UsuarioController?acao=mostrarvendedor">Lista de Vendedores</a>  
                        <li class="nav-item">
                            
                            <a class="nav-link" href="UsuarioController?acao=mostrarcomprador">Lista de Compradores</a>                          
                        <li class="nav-item">
                            
                            <a class="nav-link" href="ProdutoController?acao=relatorioestoque">Relatório do Estoque Disponível</a>                          
                        <li class="nav-item">
                            
                            <a class="nav-link" href="VendaController?acao=relatoriovenda">Relatório das Vendas</a>                          
                        <li class="nav-item">
                            
                            <a class="nav-link" href="ProdutoController?acao=liberarvenda">Liberar um produto para a venda</a> 
                            
                       
      <%  
    } else if(usuario.getTipo().equals("1")) { %>
        
     <h5>Bem vindo, vendedor <%= usuario.getNome()%></h5>
            
                        <li class="nav-item">
                            
                            <a class="nav-link" href="ClienteController?acao=mostrar">Mostrar Cliente</a>   
                            
                        <li class="nav-item">
                            
                            <a class="nav-link" href="ProdutoController?acao=mostrar">Realizar Venda</a>   
                        
                        <li class="nav-item">
                            
                            <a class="nav-link" href="VendaController?acao=mostrar">Vendas Realizadas</a> 
      <% 
    } else if(usuario.getTipo().equals("2")) { %>
    
    <h5>Bem vindo, comprador <%= usuario.getNome()%></h5>
            
                        <li class="nav-item">
                            
                            <a class="nav-link" href="FornecedorController?acao=mostrar">Mostrar Fornecedores</a> 
                            
                        <li class="nav-item">
                            
                            <a class="nav-link" href="CategoriaController?acao=mostrar">Mostrar Categorias</a> 
                            
                        <li class="nav-item">
                            
                            <a class="nav-link" href="ProdutoController?acao=liberarvenda">Liberar um produto para a venda</a> 
                            
                        <li class="nav-item">
                            
                            <a class="nav-link" href="ProdutoController?acao=mostrar">Realizar Compra</a> 
                        
                        <li class="nav-item">
                            
                            <a class="nav-link" href="CompraController?acao=mostrar">Compras Realizadas</a> 
                     
      <% }  %>
                           
            
                </div> 
    </body>
</html>
