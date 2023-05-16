package jpaMaven.model;

import java.io.Serializable;
import javax.persistence.*;

//define a entidade que será a tabela no banco de dados
@Entity(name = "PessoaModel")
public class Pessoa implements Serializable {
	/*
	Serializable = Ela dá capacidade da classe produzir um formato em que os dados do objeto sejam usados de forma externa ao 
	código, 
	em geral ele é persistido em alguma forma de armazenamento temporário ou permanente ou é transmitido para outro recurso*/
	 

	private static final long serialVersionUID = 1L;
	//@id identificação de chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*Anotação @GeneratedValue, a qual deve ser declarada quando a geração do 
	 * valor da chave-primária é de responsabilidade do banco de dados.
	 */
	Integer id;
	String nome;
	String email;
	String cargo;

	/*
	 * O super() serve para chamar o construtor da superclasse. Ele sempre é chamado, mesmo quando não está explícito no código,
	 *  quando for explicitado deve ser o primeiro item dentro do construtor. */
	 
	public Pessoa(Integer id, String nome, String email, String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
	}
	
	public Pessoa () {
		
	}

	//@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", cargo=" + cargo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
