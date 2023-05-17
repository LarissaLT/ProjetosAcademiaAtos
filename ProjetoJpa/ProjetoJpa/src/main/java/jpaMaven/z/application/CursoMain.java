package jpaMaven.z.application;

import jpaMaven.model.Curso;
import jpaMaven.repository.curso.CursoRepository;
import jpaMaven.repository.curso.CursoRepositoryImpl;

import java.util.List;
import java.util.Scanner;


public class CursoMain {
	Scanner scanner = new Scanner(System.in);
	private CursoRepository cursoRepository = new CursoRepositoryImpl();


	public static void main(String[] args) {
		CursoMain principal = new CursoMain();
		principal.executar();
	}

	public void executar() {
		System.out.print("Digite as opções desejadas: 1-Inserir Curso, 2-Alterar Curso, 3-Visualizar Curso, 4-Deletar Curso: ");
		String opcao = scanner.nextLine();


		switch (opcao) {
			case "1":
				inserirCurso();
				break;
			case "2":
				alterarCurso();
				break;
			case "3":
				listarCursos();
				break;
			case "4":
				excluirCurso();
				break;
			default:
				System.out.println("Opção inválida.");
				break;
		}

		scanner.close();
	}

	public void inserirCurso() {
		System.out.print("Digite o nome do curso: ");
		String nome = scanner.nextLine();

		Curso curso = new Curso(null, nome);

		cursoRepository.inserir(curso);
		System.out.print("Dados inseridos com sucesso!");

		scanner.close();

	}

	public void alterarCurso() {
		System.out.print("Digite o id que deseja alterar: ");
		long id = scanner.nextInt();
		scanner.nextLine();

		Curso update = cursoRepository.buscar(id);

		System.out.print("Digite o nome para alterar: ");
		String novoNome = scanner.nextLine();

		update.setNome(novoNome);

		cursoRepository.atualizar(update);
		System.out.print("Dados Alterados com sucesso!");
	}

	public void listarCursos() {
		List<Curso> cursos = cursoRepository.listar();

		if (cursos.isEmpty()) {
			System.out.println("Não há cursos cadastradas.");
		} else {
			System.out.println("Lista de Cursos:");
			for (Curso curso : cursos) {
				System.out.println("ID: " + curso.getId());
				System.out.println("Nome: " + curso.getNome());
			}
		}
	}

	public void excluirCurso() {
		System.out.print("Digite o ID da curso que deseja excluir: ");
		long id = scanner.nextInt();
		scanner.nextLine();

		Curso curso = cursoRepository.buscar(id);
		if (curso == null) {
			System.out.println("Curso com o ID informado não encontrada.");
			return;
		}

		System.out.print("Tem certeza que deseja excluir a curso " + curso.getNome() + "? (S/N): ");
		String confirmacao = scanner.nextLine();

		if (confirmacao.equalsIgnoreCase("S")) {
			cursoRepository.excluir(curso.getId());
			System.out.println("Curso excluído com sucesso!");
		} else {
			System.out.println("Exclusão cancelada pelo usuário.");
		}
	}
}

