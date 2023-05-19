package jpaMaven.repository.professor;

import jpaMaven.model.Curso;
import jpaMaven.model.Professor;

import java.util.List;

public interface ProfessorRepository {

    void inserir(Professor professor);
    Professor buscar(Long id);
    void atualizar(Professor professor);
    List<Professor> listar();
    void excluir(Long id);

}
