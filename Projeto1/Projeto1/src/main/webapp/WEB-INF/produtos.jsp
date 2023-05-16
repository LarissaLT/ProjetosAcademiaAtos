<%@ page import="br.com.atos.produto.ProdutoModel" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Produtos</title>
</head>
<body>
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
            <form method="POST" action="/ProjetoReferencia/produtos">
            <input type="hidden" name="id" value="<%= produto.getId() %>">
            <input type="hidden" name="_method" value="DELETE">
            <input type="submit" value="Excluir">
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
<h2>Inserir Produto</h2>
<form method="POST" action="/ProjetoReferencia/produtos">
    Código: <input type="text" name="codigo" required><br>
    Nome: <input type="text" name="nome" required><br>
    Categoria:
    <input type="text" name="categoria"><br>
    Valor: <input type="number" name="valor" step="0.01" min="0" required><br>
    Quantidade: <input type="number" name="quantidade" min="0" required><br>
    <input type="submit" value="Inserir">
</form>
</body>
</html>