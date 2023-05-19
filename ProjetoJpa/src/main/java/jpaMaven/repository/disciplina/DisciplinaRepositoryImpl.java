package jpaMaven.repository.disciplina;

import jpaMaven.core.db.MySQLdb;
import jpaMaven.model.Disciplina;
import jpaMaven.model.Professor;
import jpaMaven.repository.professor.ProfessorRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DisciplinaRepositoryImpl implements DisciplinaRepository {

    private final EntityManager entityManager;

    public DisciplinaRepositoryImpl() {
        this.entityManager = MySQLdb.getEntityManager();
    }
    public void inserir(Disciplina disciplina) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(disciplina);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {

        }
    }

    public Disciplina buscar(Long id) {
        try {
            entityManager.getTransaction().begin(); // Inicia uma transação

            Disciplina disciplina = entityManager.find(Disciplina.class, id);

            entityManager.getTransaction().commit(); // Confirma a transação

            return disciplina;
        } catch (Exception e) {
            entityManager.getTransaction().rollback(); // Desfaz a transação em caso de erro
            throw e;
        } finally {

        }
    }

    public void atualizar(Disciplina disciplina) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(disciplina);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {

        }
    }

    public List<Disciplina> listar(){
        try {
            String jpql = "SELECT d FROM Disciplina d";
            Query query = entityManager.createQuery(jpql);

            List<Disciplina> disciplinas = query.getResultList();

            return disciplinas;
        } finally {

        }
    }

    public void excluir(Long id) {
        try {
            Disciplina disciplina = entityManager.find(Disciplina.class, id);

            if (disciplina != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(disciplina);
                entityManager.getTransaction().commit();
            } else {
                System.out.println("Disciplina com o ID informado não encontrado.");
            }
        } finally {

        }
    }

}
