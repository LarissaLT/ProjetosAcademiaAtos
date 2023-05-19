<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="br.com.atos.produto.ProdutoModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Sistema/Cadastro</title>
</head>


<body>
<section class="sistema">
    <container>
        <h1>Cadastro</h1>
        <div class="update">
        <form method="POST" action="/Projeto1/produtos">
          <div >Codigo:<input type="text" name="codigo" required ></input></div>
            <div  >Nome:<input type="text" name="nome" required></input></div>
            <div >Categoria:<input type="text" name="categoria"></input></div>
            <div  >Valor:<input type="number" name="valor" step="0.01" min="0" required></input></div>
             <div >Quantidade:<input  type="number" name="quantidade" min="0" required></input></div>
            
            <button class="button" type="submit" value="Cadastrar">Cadastrar</button>
		</form>


        </div>
      
    </container>
</section>
</body>
</html>