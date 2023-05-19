package jpaMaven.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//define a entidade que será a tabela no banco de dados
@Entity(name = "Aluno")
public class Aluno implements Serializable {
	/*
	Serializable = Ela dá capacidade da classe produzir um formato em que os dados do objeto sejam usados de forma externa ao 
	código, 
	em geral ele é persistido em alguma forma de armazenamento temporário ou permanente ou é transmitido para outro recurso*/
	 

	private static final long serialVersionUID = 1L;
	//@id identificação de chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	/*Anotação @GeneratedValue, a qual deve ser declarada quando a geração do 
	 * valor da chave-primária é de responsabilidade do banco de dados.
	 */
	private Long id;
	private String nome;

	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;

	@ManyToMany
	@JoinTable(name = "Aluno_disciplinas",
			joinColumns = @JoinColumn(name = "aluno_"),
			inverseJoinColumns = @JoinColumn(name = "disciplinas_id"))
	private List<Disciplina> disciplinas = new ArrayList<>();


	/*
	 * O super() serve para chamar o construtor da superclasse. Ele sempre é chamado, mesmo quando não está explícito no código,
	 *  quando for explicitado deve ser o primeiro item dentro do construtor. */

	public Aluno() {
	}

	public Aluno(Long id, String nome, Curso curso, Professor professor) {
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.professor = professor;
	}

	public Aluno(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Aluno{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", curso=" + curso +
				", professor=" + professor +
				", disciplina=" + disciplinas +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
