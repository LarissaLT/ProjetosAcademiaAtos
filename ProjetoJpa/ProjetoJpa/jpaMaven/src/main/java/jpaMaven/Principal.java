package jpaMaven;

import java.io.IOException;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import br.com.loggin.Log;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		//LOGGER
		Log meuLogger = new Log("Log.txt");
		try {
			//Log meuLogger = new Log("Log.txt");
			meuLogger.logger.setLevel(Level.FINE);
			meuLogger.logger.info("Log de informação");
			meuLogger.logger.warning("Log de Aviso");
			meuLogger.logger.severe("Log Severo");
			

		} catch (Exception e) {
			meuLogger.logger.info("Exception:" + e.getMessage()); //escrever no arquivo de log o erro
            e.printStackTrace();//escrever no console o erro

		}
		
		
		Pessoa p1 = new Pessoa(null, "Lucas", "lucas@gmail.com", "Professor");
		Pessoa p2 = new Pessoa(null, "João", "joao@gmail.com", "Aluno");
		Pessoa p3 = new Pessoa(null, "Pedro", "pedro@gmail.com", "Funcionário");
		Pessoa p;
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula_jpa");//exemplo_jpa01 tem q ser o mesmo nome 'persistence-unit name 'usado no 'persistence.xml
		EntityManager em = emf.createEntityManager();
		meuLogger.logger.info("\nA entidade manager factory exemplo_jpa01 foi criada!!");//escrever no log
		
		em.getTransaction().begin(); //abrir transacao com o db
		p = em.find(Pessoa.class, 3); //'find' serve para pesquisar nesse caso obter pelo id 
		System.out.println("Pessoa: "+p);
		//p.setNome("Higor");  //'set' serve para atualizar na tabela o mesmo que 'UPDATE'		
		//em.remove(p);
		//em.persist(p1);  //persist serve para uma criar pessoa na tabela
		//em.persist(p2);
		//em.persist(p3);
		em.getTransaction().commit(); //fechar transacao com o db


		

		//p = em.find(Pessoa.class, 2);
		//System.out.println(p);
	}

}
