package jpaMaven;

import jpaMaven.core.logger.Log;
import jpaMaven.model.Aluno;
import jpaMaven.model.Curso;
import jpaMaven.model.Disciplina;
import jpaMaven.model.Professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

public class Main {

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
        curso1.setNome("1º ano");
        entitymanager.persist(curso1);

        // Cadastrar entidade do curso
        Curso curso2 = new Curso();
        curso2.setNome("2º ano");
        entitymanager.persist(curso2);

        /*-------------------------------------------------*/

        // Cadastrar entidade da disciplina
        Disciplina disciplina1 = new Disciplina();
        disciplina1.setNome("Matemática");
        entitymanager.persist(disciplina1);

        // Cadastrar entidade da disciplina
        Disciplina disciplina2 = new Disciplina();
        disciplina2.setNome("Português");
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


        // Criando a entidade do aluno 1
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Ana");
        aluno1.setCurso(curso1);
        aluno1.setProfessor(professor1);
        aluno1.setDisciplinas(Arrays.asList(disciplina1));
        entitymanager.persist(aluno1);

        // Criando a entidade do aluno 2
        Aluno aluno2 = new Aluno();
        aluno2.setNome("João");
        aluno2.setCurso(curso1);
        aluno2.setProfessor(professor1);
        aluno2.setDisciplinas(Arrays.asList(disciplina2));
        entitymanager.persist(aluno2);

        // Criando a entidade do aluno 3
        Aluno aluno3 = new Aluno();
        aluno3.setNome("Pedro");
        aluno3.setCurso(curso2);
        aluno3.setProfessor(professor2);
        aluno3.setDisciplinas(Arrays.asList(disciplina1));
        entitymanager.persist(aluno3);

        // Criando a entidade do aluno 4
        Aluno aluno4 = new Aluno();
        aluno4.setNome("Lúcia");
        aluno4.setCurso(curso2);
        aluno4.setProfessor(professor1);
        aluno4.setDisciplinas(Arrays.asList(disciplina2));
        entitymanager.persist(aluno4);

        /*-------------------------------------------------*/

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }

}
