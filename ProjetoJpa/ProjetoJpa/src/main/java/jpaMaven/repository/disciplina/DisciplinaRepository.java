package jpaMaven.repository.disciplina;

import jpaMaven.model.Disciplina;
import jpaMaven.model.Professor;

import java.util.List;

public interface DisciplinaRepository {

    void inserir(Disciplina disciplina);
    Disciplina buscar(Long id);
    void atualizar(Disciplina disciplina);
    List<Disciplina> listar();
    void excluir(Long id);

}
