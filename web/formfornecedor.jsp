
<%@page import="Aplicacao.Fornecedor"%>
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
               Fornecedor aux = (Fornecedor)request.getAttribute("fornecedor");
            %>
            <div class="col-6 mt-5">
                  <h4>Incluir Fornecedor</h4>
                  <form method="POST" action="FornecedorController" >
                      <input type="hidden" class="form-control" name="id" value="<%= aux.getIdfornecedor() %>">
                      
                    <div class="form-group">
                        <label for="Razao Social">Razão Social</label>
                        <input type="text" class="form-control" name="razao_social" value="<%= aux.getRazaosocial() %>" maxlength="50" placeholder="Sua Razão Social">
                    </div>
                    <div class="form-group">
                        <label for="CNPJ">CNPJ</label>
                        <input type="text" class="form-control"  name="cnpj" value="<%= aux.getCnpj() %>" placeholder="Seu CNPJ">
                    </div> 
                    <div class="form-group">
                        <label for="Endereco">Endereço</label>
                        <input type="text" class="form-control"  name="endereco" value="<%= aux.getEndereco() %>" placeholder="Seu Endereço">
                    </div>
                    <div class="form-group">
                        <label for="Bairro">Bairro</label>
                        <input type="text" class="form-control"  name="bairro" value="<%= aux.getBairro() %>" placeholder="Seu Bairro">
                    </div>
                    <div class="form-group">
                        <label for="Cidade">Cidade</label>
                        <input type="text" class="form-control"  name="cidade" value="<%= aux.getCidade() %>" placeholder="Sua Cidade">
                    </div>
                    <div class="form-group">
                        <label for="UF">UF</label>
                        <input type="text" class="form-control"  name="uf" value="<%= aux.getUf() %>" r placeholder="Sua unidade federativa">
                    </div>
                    <div class="form-group">
                        <label for="CEP">CEP</label>
                        <input type="text" class="form-control"  name="cep" value="<%= aux.getCep() %>" placeholder="Seu CEP">
                    </div>
                    <div class="form-group">
                        <label for="Telefone">Telefone</label>
                        <input type="text" class="form-control"  name="telefone" value="<%= aux.getTelefone() %>" placeholder="Seu Telefone">
                    </div>
                    <div class="form-group">
                        <label for="Email">Email</label>
                        <input type="text" class="form-control"  name="email" value="<%= aux.getEmail() %>" placeholder="Seu Email">
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                    <a href="FornecedorController?acao=mostrar" class="btn btn-outline-danger">Retornar</a>
                </form>
            </div>
        </div>
    </body>
</html>
