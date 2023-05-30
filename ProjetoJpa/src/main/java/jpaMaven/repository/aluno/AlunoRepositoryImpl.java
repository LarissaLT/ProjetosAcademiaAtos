package jpaMaven.repository.aluno;

import jpaMaven.model.Aluno;
import jpaMaven.core.db.MySQLdb;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AlunoRepositoryImpl implements AlunoRepository {

    private final EntityManager entityManager;

    public AlunoRepositoryImpl() {
        this.entityManager = MySQLdb.getEntityManager();
    }

    @Override
    public void matricularAluno(Aluno aluno) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    //Recebe uma instância de aluno como parâmetro e inicia uma transação utilizando o entityManager.
    //Em seguida, persiste a entidade aluno no banco de dados usando o método persist()
    public void inserir(Aluno aluno) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    //Recebe um ID como parâmetro e utiliza o entityManager para buscar a entidade aluno correspondente ao ID fornecido
    public Aluno buscar(Long id) {
        return entityManager.find(Aluno.class, id);
    }

    //Recebe uma instância de aluno como parâmetro
    public void atualizar(Aluno aluno) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(aluno);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {

        }
    }

    public List<Aluno> listar(){
        try {
            String jpql = "SELECT a FROM Aluno a"; // Consulta JPQL para selecionar todas as alunos
            Query query = entityManager.createQuery(jpql);

            List<Aluno> alunos = query.getResultList(); // Obter a lista de alunos

            return alunos;
        } finally {

        }
    }

    public void excluir(Long id) {
        try {
            // Encontrar o usuário com o ID fornecido
            Aluno aluno = entityManager.find(Aluno.class, id);

            if (aluno != null) {
                // Remover o aluno do banco de dados
                entityManager.getTransaction().begin();
                entityManager.remove(aluno);
                entityManager.getTransaction().commit();
            } else {
                System.out.println("aluno com o ID informado não encontrado.");
            }
        } finally {

        }
    }
}
