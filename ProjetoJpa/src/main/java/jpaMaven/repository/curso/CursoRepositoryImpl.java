package jpaMaven.repository.curso;

import jpaMaven.core.db.MySQLdb;
import jpaMaven.model.Curso;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CursoRepositoryImpl implements CursoRepository {

    private final EntityManager entityManager;

    public CursoRepositoryImpl() {
        this.entityManager = MySQLdb.getEntityManager();
    }
    public void inserir(Long curso) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(curso);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {

        }
    }

    @Override
    public void inserir(Curso curso) {

    }

    public Curso buscar(Long id) {
        return entityManager.find(Curso.class, id);
    }

    public void atualizar(Curso curso) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(curso);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
        }
    }

    public List<Curso> listar(){
        try {
            String jpql = "SELECT a FROM Curso a";
            Query query = entityManager.createQuery(jpql);

            List<Curso> cursos = query.getResultList();

            return cursos;
        } finally {
        }
    }

    public void excluir(Long id) {
        try {
            Curso curso = entityManager.find(Curso.class, id);

            if (curso != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(curso);
                entityManager.getTransaction().commit();
            } else {
                System.out.println("curso com o ID informado não encontrado.");
            }
        } finally {

        }
    }

}
