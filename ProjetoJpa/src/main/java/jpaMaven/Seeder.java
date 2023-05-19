package jpaMaven;

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
    public static void main(String[] args) throws IOException {
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

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("projeto_jpa");
        EntityManager entitymanager = emfactory.createEntityManager();
        meuLogger.logger.info("\nA entidade manager factory Projeto_jpa foi criada!!");

        entitymanager.getTransaction().begin();

        // Cadastrar entidade do curso
        Curso curso1 = new Curso();
        curso1.setNome("Básico");
        entitymanager.persist(curso1);

        // Cadastrar entidade do curso
        Curso curso2 = new Curso();
        curso2.setNome("Intermediário");
        entitymanager.persist(curso2);

        // Cadastrar entidade do curso
        Curso curso3 = new Curso();
        curso3.setNome("Avançado");
        entitymanager.persist(curso3);

        /*-------------------------------------------------*/

        // Cadastrar entidade da disciplina
        Disciplina disciplina1 = new Disciplina();
        disciplina1.setNome("Inglês");
        entitymanager.persist(disciplina1);

        // Cadastrar entidade da disciplina
        Disciplina disciplina2 = new Disciplina();
        disciplina2.setNome("Espanhol");
        entitymanager.persist(disciplina2);

        /*-------------------------------------------------*/

        // Cadastrar entidade do professor
        Professor professor1 = new Professor();
        professor1.setNome("Carlos");
        entitymanager.persist(professor1);

        // Cadastrar entidade do professor
        Professor professor2 = new Professor();
        professor2.setNome("Rosana");
        entitymanager.persist(professor2);

        /*-------------------------------------------------*/


        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }

}
