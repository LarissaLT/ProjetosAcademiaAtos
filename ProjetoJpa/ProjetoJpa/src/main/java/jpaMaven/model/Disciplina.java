package jpaMaven.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Disciplina")
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@ManyToMany(mappedBy = "disciplinas")
	private List<Aluno> alunos = new ArrayList<>();


	public Disciplina(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Disciplina() {
	}

	@Override
	public String toString() {
		return "Disciplina{" +
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
