package jpaMaven.repository;

import jpaMaven.model.Pessoa;

import java.util.List;

public interface PessoaRepository {

    void inserir(Pessoa pessoa);
    Pessoa buscar( int id);
    void atualizar(Pessoa pessoa);
    List<Pessoa> listarPessoas();
    void excluir(int id);

}
