package jpaMaven.repository.aluno;

import jpaMaven.model.Aluno;

import java.util.List;

public interface AlunoRepository {

    void inserir(Aluno aluno);
    Aluno buscar(Long id);
    void atualizar(Aluno aluno);
    List<Aluno> listar();
    void excluir(Long id);

    void fecharConexao();

}
