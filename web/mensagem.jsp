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
        <jsp:include page="cabecalho.jsp" />
        
        <div class="col-8 mt-5">

                <div class="alert alert-success" role="alert">
                    <h5>
                        <%= request.getAttribute("mensagem") %>
                    </h5>
                </div>

                <p></p>
                <div><a href="<%=request.getAttribute("link")%>">Retornar</a></div>

                   
            </div>
        </div>
        
    </body>
</html>
