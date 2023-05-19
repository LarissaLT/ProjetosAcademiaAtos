

<%@ page import="br.com.atos.produto.ProdutoModel" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <title>Produtos</title>
</head>
<body>
<section class="sistema">
<container>
<h1>Produtos</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Código</th>
        <th>Nome</th>
        <th>Categoria</th>
        <th>Valor</th>
        <th>Quantidade</th>
    </tr>
    </thead>
    <tbody>
    <% List<ProdutoModel> produtos = (List<ProdutoModel>) request.getAttribute("produtos"); %>
    <% if (produtos != null && !produtos.isEmpty()) { %>
    <% for (ProdutoModel produto : produtos) { %>
    <tr>
        <td><%= produto.getId() %></td>
        <td><%= produto.getCodigo() %></td>
        <td><%= produto.getNome() %></td>
        <td><%= produto.getCategoria() %></td>
        <td><%= produto.getValor() %></td>
        <td><%= produto.getQuantidade() %></td>

        <td>
            <form method="POST" action="/Projeto1/produtos">
    		<input  type="hidden" name="id" value="<%= produto.getId() %>">
            <input  type="hidden" name="method" value="DELETE">
            <input class="button" type="submit" value="Excluir">
            </form>
        </td>
        	
        <td>
           
            <form method="POST" action="/Projeto1/produtos">
    		<input type="hidden" name="id" value="<%= produto.getId() %>">
            <input type="hidden" name="method" value="VIEW">
            <input class="button" type="submit" value="Atualizar">
            </form>
        </td>

    </tr>
    <% } %>
    <% } else { %>
    <tr>
        <td colspan="6">Nenhum produto encontrado.</td>
    </tr>
    <% } %>
    </tbody>
</table>


</container>
</section>

</body>
</html>