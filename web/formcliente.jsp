
<%@page import="Aplicacao.Cliente"%>
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
               Cliente aux = (Cliente)request.getAttribute("cliente");
            %>
            <div class="col-6 mt-5">
                  <h4>Incluir Cliente</h4>
                  <form method="POST" action="ClienteController" >
                      <input type="hidden" class="form-control" name="id" value="<%= aux.getIdcliente() %>">
                      
                    <div class="form-group">
                        <label for="Nome">Nome</label>
                        <input type="text" class="form-control" name="nome" value="<%= aux.getNome() %>" required size="30" maxlength="100" placeholder="Seu Nome">
                    </div>
                    <div class="form-group">
                        <label for="CPF">CPF</label>
                        <input type="text" class="form-control"  name="cpf" value="<%= aux.getCpf() %>" required size="14" placeholder="Seu CPF">
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
                    <a href="ClienteController?acao=mostrar" class="btn btn-outline-danger">Retornar</a>
                </form>
            </div>
        </div>
    </body>
</html>
