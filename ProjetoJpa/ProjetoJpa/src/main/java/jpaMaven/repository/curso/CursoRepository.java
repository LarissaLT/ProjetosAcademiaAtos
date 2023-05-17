package jpaMaven.repository.curso;

import jpaMaven.model.Curso;

import java.util.List;

public interface CursoRepository {

    void inserir(Curso curso);
    Curso buscar(Long id);
    void atualizar(Curso curso);
    List<Curso> listar();
    void excluir(Long id);

}
