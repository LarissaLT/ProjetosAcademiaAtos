package jpaMaven;

import jpaMaven.core.db.MySQLdb;
import jpaMaven.core.logger.Log;
import jpaMaven.model.Curso;
import jpaMaven.model.Disciplina;
import jpaMaven.model.Professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.logging.Level;

public class Seeder {
    public void execute() throws IOException {
        // LOGGER
        Log meuLogger = new Log("Log.txt");
        try {
            meuLogger.logger.setLevel(Level.FINE);
            meuLogger.logger.info("Log de informação");
            meuLogger.logger.warning("Log de Aviso");
            meuLogger.logger.severe("Log Severo");
        } catch (Exception e) {
            meuLogger.logger.info("Exception:" + e.getMessage()); // escrever no arquivo de log o erro
            e.printStackTrace(); // escrever no console o erro
        }

        EntityManager entityManager = MySQLdb.getEntityManager();
        meuLogger.logger.info("\nA entidade manager factory Projeto_jpa foi criada!!");

        entityManager.getTransaction().begin();

        // Cadastrar entidade do curso
        Curso curso1 = new Curso();
        curso1.setNome("Básico");
        entityManager.persist(curso1);

        // Cadastrar entidade do curso
        Curso curso2 = new Curso();
        curso2.setNome("Intermediário");
        entityManager.persist(curso2);

        // Cadastrar entidade do curso
        Curso curso3 = new Curso();
        curso3.setNome("Avançado");
        entityManager.persist(curso3);

        /*-------------------------------------------------*/

        // Cadastrar entidade da disciplina
        Disciplina disciplina1 = new Disciplina();
        disciplina1.setNome("Inglês");
        entityManager.persist(disciplina1);

        // Cadastrar entidade da disciplina
        Disciplina disciplina2 = new Disciplina();
        disciplina2.setNome("Espanhol");
        entityManager.persist(disciplina2);

        /*-------------------------------------------------*/

        // Cadastrar entidade do professor
        Professor professor1 = new Professor();
        professor1.setNome("Carlos");
        entityManager.persist(professor1);

        // Cadastrar entidade do professor
        Professor professor2 = new Professor();
        professor2.setNome("Rosana");
        entityManager.persist(professor2);

        /*-------------------------------------------------*/


        entityManager.getTransaction().commit();

    }

}
