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


<head>
    <title>Alterar Produto</title>
    <style>
        /* Estilos CSS */
    </style>
</head>
<body>
<section class="sistema">
    <container>
    <h1>Alterar Produto</h1>

    <%-- Recuperar o objeto ProdutoModel do atributo "produtounico" --%>
    <% ProdutoModel produtounico = (ProdutoModel) request.getAttribute("produtounico"); %>

    <%-- Verificar se o produto existe --%>
    <% if (produtounico != null) { %>
        <form method="POST" action="/Projeto1/produtos">
            <input type="hidden" name="id" value="<%= produtounico.getId() %>">

            <div>
                <label for="codigo">Código:</label>
                <input type="text" id="codigo" name="codigo" required value="<%= produtounico.getCodigo() %>">
            </div>

            <div>
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" required value="<%= produtounico.getNome() %>">
            </div>

            <div>
                <label for="categoria">Categoria:</label>
                <input type="text" id="categoria" name="categoria" value="<%= produtounico.getCategoria() %>">
            </div>

            <div>
                <label for="valor">Valor:</label>
                <input type="number" id="valor" name="valor" step="0.01" min="0" required value="<%= produtounico.getValor() %>">
            </div>

            <div>
                <label for="quantidade">Quantidade:</label>
                <input type="number" id="quantidade" name="quantidade" min="0" required value="<%= produtounico.getQuantidade() %>">
            </div>
			
            <input type="hidden" name="method" value="PUT">
            <input class="button" type="submit" value="Atualizar">
        </form>
        
       </container>
</section>     
    <% } else { %>
        <p>O produto não foi encontrado.</p>
    <% } %>
</body>
</html>