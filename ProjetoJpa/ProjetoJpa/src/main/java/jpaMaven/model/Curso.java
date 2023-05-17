package jpaMaven.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "curso_id")
	private List<Aluno> alunos = new ArrayList<>();


	public Curso(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Curso() {
	}

	@Override
	public String toString() {
		return "Curso{" +
				"id=" + id +
				", nome='" + nome + '\'' +
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}
