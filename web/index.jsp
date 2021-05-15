<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

<!-- Navegação -->

<%@include file="cabecalho.jsp" %><!-- Inclusão do cabeçalho -->

<!--- Imagem rodando -->

<div id="slides" class="carousel slide" data-ride="carousel">
	
<ul class="carousel-indicators">
	<li data-target="#slides" data-slide-to="0" class="active"></li>
	<li data-target="#slides" data-slide-to="1"></li>
	<li data-target="#slides" data-slide-to="2"></li>
</ul>
<div class="carousel-inner">
	<div class="carousel-item active">
            <img src="img/background22.jpg" >
		<div class="carousel-caption">
			<h1 class="display-2">Européias</h1>
			<h3>Tudo, a toda hora, em qualquer lugar :)</h3>
			<a href="ProdutoController?acao=mostrar"><button type="button" class="btn btn-dark btn-lg">Produtos</button></a>
                        <% if (usuario.isIsValid()==false) { %>
			<a href="login.jsp"><button type="button" class="btn btn-primary btn-lg">Faça o login</button></a>
                        <% } %>
		</div>
	</div>
	<div class="carousel-item">
		<img src="img/background11.jpg">
	</div>
	<div class="carousel-item">
		<img src="img/background33.jpg" >
	</div>
</div>
</div>

<!--- Ofertas -->

<div class="container-fluid">
<div class="row jumbotron">
	<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10"> <!-- AJEITANDO AS COLUNAS -->
		<p class="lead">Preço baixo e as melhores ofertas de smartphones, notebooks, TV LED, geladeiras, móveis, tablets e mais na Européias. Aproveite!</p>
	</div>

	<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
		<a href="ProdutoController?acao=mostrar"><button type="button" class="btn btn-outline-secondary btn-lg">Produtos</button></a>
		
	</div>
	
</div>
</div>

<!-- Titulo produtos -->

<div class="container-fluid padding">
<div class="row welcome text-center">
	<div class="col-12">
		<h1 class="display-4">Produtos disponíveis</h1>
	</div>
	<hr>
</div>
</div>

<!--- Cards Produtos -->

<div class="container-fluid padding">
<div class="row padding">
	<div class="col-md-4">
		<div class="card">
			<img class="card-img-top" src="img/geladeiralg.jpg">
			<div class="card-body">
				<h4 class="card-title">Refrigeradores</h4>
				<p class="card-text">Refrigerador Side by Side LG de 02 Portas Frost Free com 601 Litros, Moist Balance Crisper, Aço Escovado - GC-L247S</p>	
				<a class="btn btn-outline-secondary" href="ProdutoController?acao=mostrar">Produto disponível?</a>		
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card">
			<img class="card-img-top" src="img/tvsamsung.jpg">
			<div class="card-body">
				<h4 class="card-title">Smart TV's</h4>
				<p class="card-text">Samsung Smart TV Crystal UHD TU8000 50" 4K, Design sem Limites, Alexa built in, Controle Único, Visual Livre de Cabos, Modo Ambiente</p>	
				<a class="btn btn-outline-secondary" href="ProdutoController?acao=mostrar">Produto disponível?</a>		
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card">
			<img class="card-img-top" src="img/playstation5.jpg">
			<div class="card-body">
				<h4 class="card-title">Videogames</h4>
				<p class="card-text">Console Playstation 5 825GB SSD + 2 Controles Sem Fio DualSense - Branco + Cabo USB e HDMI</p>	
				<a class="btn btn-outline-secondary" href="ProdutoController?acao=mostrar">Produto disponível?</a>		
			</div>
		</div>
	</div>
               
    </div>
    
    <div class="row text-center padding">
        <div class="col-12">
		<h2>E muito mais !!!</h2>
                <a class="btn btn-outline-secondary" href="ProdutoController?acao=mostrar">Confira aqui</a>
                
	</div>
    

</div>
</div>

<hr class="my-4">


<!--- Metodos de pagamento -->

<div class="container-fluid padding">
<div class="row welcome text-center"> <!-- row e welcome são classes do BS -->
	<div class="col-12">
		<h1 class="display-4">Métodos de pagamento</h1>
	</div>
	<hr>
	<div class="col-12">
		<p class="lead">Aqui na Européias você escolhe a opção que melhor se adequa ao seu gosto.</p>
	</div>
</div>
</div>


<!--- Formas -->

<div class="container-fluid padding">
<div class="row text-center padding">
	<div class="col-xs-12 col-sm-6 col-md-4">
		
                <img src="img/cartaodecredito.jpg" width="300" height="200">             
		<h3>Cartão de crédito</h3>
		<p>Para aqueles que não saem de casa sem o cartãozinho no bolso.</p>
	</div>	
	<div class="col-xs-12 col-sm-6 col-md-4">
		
                <img src="img/dinheiro.jpg" width="300" height="200"> 
		<h3>Dinheiro</h3>
		<p>Prefere o conforto e a segurança de não ter nenhum possível problema?</p>
	</div>	
	<div class="col-xs-12 col-md-4">
            
		<img src="img/pix.jpg" width="300" height="200"> 
		<h3>Pix</h3>
		<p>Faz o Pix? Fazemos!</p>
	</div>	
</div>
<hr class="my-4">
</div>

<!--- Redes -->

<div class="container-fluid padding">
<div class="row text-center padding">
	<div class="col-12">
		<h2>Acompanhe nosso trabalho online :)</h2>
	</div>
	<div class="col-12 social padding">
        <a href="http://www.facebook.com" target="blank">
        <img class="alignnone size-full wp-image-1303" src="img/facebook.png" alt="" width="100" height="95" />
        </a>
        <a href="http://www.twitter.com" target="blank">
        <img class="alignnone size-full wp-image-1303" src="img/twitter.png" alt="" width="90" height="90" />
        </a>
        <a href="http://www.instagram.com" target="blank">
        <img class="alignnone size-full wp-image-1303" src="img/instagram.png" alt="" width="110" height="110" />
        </a>     

	</div>
</div>	
</div>

<!--- Footer -->

<jsp:include page="footer.jsp" />

</body>
</html>