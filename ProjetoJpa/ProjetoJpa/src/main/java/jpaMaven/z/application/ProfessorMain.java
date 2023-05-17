package jpaMaven.z.application;

import jpaMaven.model.Professor;
import jpaMaven.repository.professor.ProfessorRepository;
import jpaMaven.repository.professor.ProfessorRepositoryImpl;

import java.util.List;
import java.util.Scanner;


public class ProfessorMain {
	Scanner scanner = new Scanner(System.in);
	private ProfessorRepository professorRepository = new ProfessorRepositoryImpl();


	public static void main(String[] args) {
		ProfessorMain principal = new ProfessorMain();
		principal.executar();
	}

	public void executar() {
		System.out.print("Digite as opções desejadas: 1-Inserir Professor, 2-Alterar Professor, 3-Visualizar Professor, 4-Deletar Professor: ");
		String opcao = scanner.nextLine();

		switch (opcao) {
			case "1":
				inserirProfessor();
				break;
			case "2":
				alterarProfesssor();
				break;
			case "3":
				listarProfessor();
				break;
			case "4":
				excluirProfessor();
				break;
			default:
				System.out.println("Opção inválida.");
				break;
		}

		scanner.close();
	}

	public void inserirProfessor() {
		System.out.print("Digite o nome do professor: ");
		String nome = scanner.nextLine();

		Professor professor = new Professor(null, nome);

		professorRepository.inserir(professor);
		System.out.print("Dados inseridos com sucesso!");

		scanner.close();

	}

	public void alterarProfesssor() {
		System.out.print("Digite o id que deseja alterar: ");
		long id = scanner.nextInt();
		scanner.nextLine();

		Professor update = professorRepository.buscar(id);

		System.out.print("Digite o nome para alterar: ");
		String novoNome = scanner.nextLine();

		update.setNome(novoNome);

		professorRepository.atualizar(update);
		System.out.print("Dados Alterados com sucesso!");
	}

	public void listarProfessor() {
		List<Professor> professores = professorRepository.listar();

		if (professores.isEmpty()) {
			System.out.println("Não há professores cadastradas.");
		} else {
			System.out.println("Lista de Professores:");
			for (Professor professor : professores) {
				System.out.println("ID: " + professor.getId());
				System.out.println("Nome: " + professor.getNome());
			}
		}
	}

	public void excluirProfessor() {
		System.out.print("Digite o ID da professor que deseja excluir: ");
		long id = scanner.nextInt();
		scanner.nextLine();

		Professor professor = professorRepository.buscar(id);
		if (professor == null) {
			System.out.println("Professor com o ID informado não encontrada.");
			return;
		}

		System.out.print("Tem certeza que deseja excluir a professor " + professor.getNome() + "? (S/N): ");
		String confirmacao = scanner.nextLine();

		if (confirmacao.equalsIgnoreCase("S")) {
			professorRepository.excluir(professor.getId());
			System.out.println("Professor excluído com sucesso!");
		} else {
			System.out.println("Exclusão cancelada pelo usuário.");
		}
	}
}

