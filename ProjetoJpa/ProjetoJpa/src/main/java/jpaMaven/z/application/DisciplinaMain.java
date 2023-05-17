package jpaMaven.z.application;

import jpaMaven.model.Disciplina;
import jpaMaven.repository.disciplina.DisciplinaRepository;
import jpaMaven.repository.disciplina.DisciplinaRepositoryImpl;

import java.util.List;
import java.util.Scanner;


public class DisciplinaMain {
	Scanner scanner = new Scanner(System.in);
	private DisciplinaRepository disciplinaRepository = new DisciplinaRepositoryImpl();


	public static void main(String[] args) {
		DisciplinaMain principal = new DisciplinaMain();
		principal.executar();
	}

	public void executar() {
		System.out.print("Digite as opções desejadas: 1-Inserir Disciplina, 2-Alterar Disciplina, 3-Visualizar Disciplina, 4-Deletar Disciplina: ");
		String opcao = scanner.nextLine();


		switch (opcao) {
			case "1":
				inserirDisciplina();
				break;
			case "2":
				alterarDisciplina();
				break;
			case "3":
				listarDisciplina();
				break;
			case "4":
				excluirDisciplina();
				break;
			default:
				System.out.println("Opção inválida.");
				break;
		}

		scanner.close();
	}

	public void inserirDisciplina() {
		System.out.print("Digite o nome do disciplina: ");
		String nome = scanner.nextLine();

		Disciplina disciplina = new Disciplina(null, nome);

		disciplinaRepository.inserir(disciplina);
		System.out.print("Dados inseridos com sucesso!");

		scanner.close();

	}

	public void alterarDisciplina() {
		System.out.print("Digite o id que deseja alterar: ");
		long id = scanner.nextInt();
		scanner.nextLine();

		Disciplina update = disciplinaRepository.buscar(id);

		System.out.print("Digite o nome para alterar: ");
		String novoNome = scanner.nextLine();

		update.setNome(novoNome);

		disciplinaRepository.atualizar(update);
		System.out.print("Dados Alterados com sucesso!");
	}

	public void listarDisciplina() {
		List<Disciplina> disciplinas = disciplinaRepository.listar();

		if (disciplinas.isEmpty()) {
			System.out.println("Não há disciplinas cadastradas.");
		} else {
			System.out.println("Lista de Disciplinas:");
			for (Disciplina disciplina : disciplinas) {
				System.out.println("ID: " + disciplina.getId());
				System.out.println("Nome: " + disciplina.getNome());
			}
		}
	}

	public void excluirDisciplina() {
		System.out.print("Digite o ID da disciplina que deseja excluir: ");
		long id = scanner.nextInt();
		scanner.nextLine();

		Disciplina disciplina = disciplinaRepository.buscar(id);
		if (disciplina == null) {
			System.out.println("Disciplina com o ID informado não encontrada.");
			return;
		}

		System.out.print("Tem certeza que deseja excluir a disciplina " + disciplina.getNome() + "? (S/N): ");
		String confirmacao = scanner.nextLine();

		if (confirmacao.equalsIgnoreCase("S")) {
			disciplinaRepository.excluir(disciplina.getId());
			System.out.println("Disciplina excluído com sucesso!");
		} else {
			System.out.println("Exclusão cancelada pelo usuário.");
		}
	}
}

