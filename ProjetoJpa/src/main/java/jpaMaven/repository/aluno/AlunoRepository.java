package jpaMaven.repository.aluno;

import jpaMaven.model.Aluno;

import java.util.List;

public interface AlunoRepository {

    void matricularAluno(Aluno aluno);
    void inserir(Aluno aluno);
    Aluno buscar(Long id);
    void atualizar(Aluno aluno);
    List<Aluno> listar();
    void excluir(Long id);
}
