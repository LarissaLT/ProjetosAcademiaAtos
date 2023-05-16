package jpaMaven.repository;

import jpaMaven.model.Pessoa;
import jpaMaven.core.db.MySQLdb;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PessoaRepositoryImpl implements PessoaRepository {

    private final EntityManager entityManager;

    public PessoaRepositoryImpl() {
        this.entityManager = MySQLdb.getEntityManager();
    }

    //Recebe uma instância de Pessoa como parâmetro e inicia uma transação utilizando o entityManager.
    //Em seguida, persiste a entidade pessoa no banco de dados usando o método persist()
    public void inserir(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    //Recebe um ID como parâmetro e utiliza o entityManager para buscar a entidade Pessoa correspondente ao ID fornecido
    public Pessoa buscar( int id) {
        return entityManager.find(Pessoa.class, id);
    }

    //Recebe uma instância de Pessoa como parâmetro
    public void atualizar(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public List<Pessoa> listarPessoas(){
        try {
            String jpql = "SELECT p FROM Pessoa p"; // Consulta JPQL para selecionar todas as pessoas
            Query query = entityManager.createQuery(jpql);

            List<Pessoa> pessoas = query.getResultList(); // Obter a lista de pessoas

            return pessoas;
        } finally {
            entityManager.close();
        }
    }

    public void excluir(int id) {
        try {
            // Encontrar o usuário com o ID fornecido
            Pessoa pessoa = entityManager.find(Pessoa.class, id);

            if (pessoa != null) {
                // Remover o pessoa do banco de dados
                entityManager.getTransaction().begin();
                entityManager.remove(pessoa);
                entityManager.getTransaction().commit();
            } else {
                System.out.println("Pessoa com o ID informado não encontrado.");
            }
        } finally {
            entityManager.close();
        }
    }

}
