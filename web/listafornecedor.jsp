<%@ page import="java.util.*" %>
<%@ page import="Aplicacao.Fornecedor" %>

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
   
        
        <div class="container mt-2 col-9">

    
            <h1>Lista de Fornecedores</h1>     
            <p></p>
            <a href="FornecedorController?acao=incluir" class="btn btn-outline-primary">Cadastrar Novo Fornecedor</a>
            <p></p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Razão Social</th>
                            <th scope="col">CNPJ</th>
                            <th scope="col">Endereço</th>
                            <th scope="col">Bairro</th> 
                            <th scope="col">Cidade</th>
                            <th scope="col">UF</th>
                            <th scope="col">CEP</th>
                            <th scope="col">Telefone</th>
                            <th scope="col">Email</th>
                            <th scope="col"><div class="float-right">Ações</div><br></th>
                        </tr>
                    </thead> 
                    <tbody>
                        <%
                            ArrayList<Fornecedor> ListaFornecedor = (ArrayList<Fornecedor>) request.getAttribute("meusFornecedores");
                            for (int i = 0; i < ListaFornecedor.size(); i++) {
                                Fornecedor aux = ListaFornecedor.get(i);
                                String link_editar = "FornecedorController?acao=editar&id="+aux.getIdfornecedor();
                                String link_excluir = "FornecedorController?acao=excluir&id="+aux.getIdfornecedor(); 
                         %>
                        <tr>
                            <td><%=aux.getIdfornecedor()%></td>
                            <td><%=aux.getRazaosocial()%></td> 
                            <td><%=aux.getCnpj()%></td> 
                            <td><%=aux.getEndereco()%></td>
                            <td><%=aux.getBairro()%></td> 
                            <td><%=aux.getCidade()%></td> 
                            <td><%=aux.getUf()%></td>
                            <td><%=aux.getCep()%></td> 
                            <td><%=aux.getTelefone()%></td> 
                            <td><%=aux.getEmail()%></td>
                            <td><a href="<%=link_excluir%>" class="btn btn-outline-danger float-right">Excluir</a> <a href="<%=link_editar%>" class="btn btn-outline-secondary float-right">Editar</a> 
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