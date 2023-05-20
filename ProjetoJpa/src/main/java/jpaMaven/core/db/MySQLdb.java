package jpaMaven.core.db;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLdb{

    private static EntityManager entityManager;


    public static EntityManager getEntityManager() {
        if(entityManager == null) {
            // O parâmetro passado para esse método, "projeto_jpa",
            // é o nome da unidade de persistência usada para configurar a conexão com o banco de dados MySQL.
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("projeto_jpa");
            entityManager = factory.createEntityManager(); // criar um obj usando o metodo create
        }
        return entityManager;
    }

    public static void fecharConexao(){
        entityManager.close();
        entityManager = null;
    }

}
