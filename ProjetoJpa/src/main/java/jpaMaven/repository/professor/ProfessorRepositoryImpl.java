package jpaMaven.repository.professor;

import jpaMaven.core.db.MySQLdb;
import jpaMaven.model.Professor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProfessorRepositoryImpl implements ProfessorRepository {

    private final EntityManager entityManager;

    public ProfessorRepositoryImpl() {
        this.entityManager = MySQLdb.getEntityManager();
    }
    public void inserir(Professor professor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(professor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
        }
    }

    public Professor buscar(Long id) {
        return entityManager.find(Professor.class, id);
    }

    public void atualizar(Professor professor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(professor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {

        }
    }

    public List<Professor> listar(){
        try {
            String jpql = "SELECT p FROM Professor p";
            Query query = entityManager.createQuery(jpql);

            List<Professor> professores = query.getResultList();

            return professores;
        } finally {

        }
    }

    public void excluir(Long id) {
        try {
            Professor professor = entityManager.find(Professor.class, id);

            if (professor != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(professor);
                entityManager.getTransaction().commit();
            } else {
                System.out.println("Professor com o ID informado não encontrado.");
            }
        } finally {

        }
    }

}
