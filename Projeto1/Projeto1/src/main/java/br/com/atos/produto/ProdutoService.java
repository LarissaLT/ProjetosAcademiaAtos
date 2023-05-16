package br.com.atos.produto;

import br.com.atos.bd.BancoDados;
import br.com.atos.exceptions.BancoDadosException;
import br.com.atos.exceptions.ProdutoNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService implements ProdutoRepository {

    private final BancoDados bd;

    public ProdutoService(BancoDados bd) {
        this.bd = bd;
    }

    public ProdutoModel buscar(int id) throws ProdutoNotFoundException {
        final String query = "SELECT * FROM produto WHERE id = ?";
        // criar um objeto que será preenchido com os dados do produto
        // encontrado no banco de dados.
        ProdutoModel produto = new ProdutoModel();
        try (Connection c = bd.conectar()) {
            // prepara a consulta para ser executada.
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);   // para que o banco encontre o id (1 é a posição da ?)
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // os valores das colunas do resultado são extraídos do ResultSet
                // e atribuídos aos campos correspondentes do objeto produto.
                produto.setId(rs.getInt("id"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setValor(rs.getFloat("valor"));
                produto.setQuantidade(rs.getInt("quantidade"));

                // preenchido com os dados do produto encontrado no banco de dados.
                return produto;
            }
        } catch (BancoDadosException | SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao consultar" + e);
        }
        throw new ProdutoNotFoundException("Produto não cadastrado");
    }

    @Override
    public List<ProdutoModel> listar() {
        final String query = "SELECT * FROM produto";
        List<ProdutoModel> produtos = new ArrayList<>();
        try (Connection c = bd.conectar()) {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProdutoModel produto = new ProdutoModel();
                produto.setId(rs.getInt("id"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setValor(rs.getFloat("valor"));
                produto.setQuantidade(rs.getInt("quantidade"));

                produtos.add(produto);
            }
        } catch (BancoDadosException | SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao consultar" + e);
        }
        return produtos;
    }

    @Override
    public void atualizar(ProdutoModel produto) {
        final String query = "UPDATE produto SET id = ?, codigo = ?, nome = ?, categoria = ?, valor = ?, quantidade = ? WHERE id = ?";
        try (Connection c = bd.conectar()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, produto.getId());
            ps.setInt(2, produto.getCodigo());
            ps.setString(3, produto.getNome());
            ps.setString(4, produto.getCategoria());
            ps.setFloat(5, produto.getValor());
            ps.setInt(6, produto.getQuantidade());

        } catch (BancoDadosException | SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao consultar" + e);
        }
    }

    @Override
    public void cadastrar(ProdutoModel produto) {
        final String query = "INSERT INTO produto(codigo, nome, categoria, valor, quantidade) VALUES (? ,?, ?, ?, ?)";
        try (Connection c = bd.conectar()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, produto.getCodigo());
            ps.setString(2, produto.getNome());;
            ps.setString(3, produto.getCategoria());
            ps.setFloat(4, produto.getValor());
            ps.setInt(5, produto.getQuantidade());
            int result = ps.executeUpdate();
            System.out.println(result);

        } catch (BancoDadosException | SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao consultar" + e);
        }
    }

    @Override
    public void excluir(int id) {
        final String query = "DELETE FROM produto WHERE id = ?";
        ProdutoModel produto = new ProdutoModel();
        try (Connection c = bd.conectar()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            int rs = ps.executeUpdate(); // int, referente ao numero de updates
        } catch (BancoDadosException | SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao consultar" + e);
        }
    }
}
