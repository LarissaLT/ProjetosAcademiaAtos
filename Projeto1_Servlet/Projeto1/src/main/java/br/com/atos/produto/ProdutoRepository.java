package br.com.atos.produto;

import br.com.atos.exceptions.ProdutoNotFoundException;

import java.util.List;
// essa interface define um contrato para um repositório
public interface ProdutoRepository {

    public ProdutoModel buscar(int id) throws ProdutoNotFoundException;
    public List<ProdutoModel> listar();
    public void cadastrar(ProdutoModel produto);
    public void atualizar(ProdutoModel produto);
    public void excluir(int id);
}
