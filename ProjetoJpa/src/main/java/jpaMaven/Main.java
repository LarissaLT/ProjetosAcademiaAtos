package jpaMaven;

import jpaMaven.model.Pessoa;
import jpaMaven.repository.PessoaRepository;
import jpaMaven.repository.PessoaRepositoryImpl;

import java.util.List;
import java.util.Scanner;


public class Main {
	Scanner scanner = new Scanner(System.in);
	private PessoaRepository pessoaRepository = new PessoaRepositoryImpl();


	public static void main(String[] args) {
		Main principal = new Main();
		principal.executar();
	}

	public void executar() {
		// Solicitar a opção desejada ao usuário
		System.out.print("Digite as opções desejadas: 1-inserir, 2-alterar, 3-visualizar, 4-deletar: ");
		String opcao = scanner.nextLine();


		// Executar a lógica com base na opção escolhida
		switch (opcao) {
			case "1":
				inserirPessoa();
				break;
			case "2":
				alterarPessoa();
				break;
			case "3":
				listarPessoas();
				break;
			case "4":
				excluirPessoa();
				break;
			default:
				System.out.println("Opção inválida.");
				break;
		}

		// Fechar a conexão com o banco de dados e encerrar o scanner
		scanner.close();
	}

	public void inserirPessoa() {
		// Solicitar os dados da pessoa ao usuário
		System.out.print("Digite o nome da pessoa: ");
		String nome = scanner.nextLine();

		System.out.print("Digite o e-mail da pessoa: ");
		String email = scanner.nextLine();

		System.out.print("Digite o cargo da pessoa: ");
		String cargo = scanner.nextLine();

		// Criar uma nova instância de Pessoa com os dados fornecidos
		Pessoa pessoa = new Pessoa(null, nome, email, cargo);

		// Inserir a nova pessoa no banco de dados no pessoaRepository
		pessoaRepository.inserir(pessoa);
		System.out.print("Dados inseridos com sucesso!");

		// Fechar a conexão com o banco de dados e encerrar o scanner no pessoaRepository
		scanner.close();

	}

	public void alterarPessoa() {
		// Solicitar o ID da pessoa que será alterada
		System.out.print("Digite o id que deseja alterar: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consumir a nova linha após a leitura do número

		// Buscar a pessoa com o ID fornecido no pessoaRepository
		Pessoa update = pessoaRepository.buscar(id);

		// Modificar os atributos da pessoa com os dados fornecidos pelo usuário
		System.out.print("Digite o nome para alterar: ");
		String novoNome = scanner.nextLine();

		// Modificar os atributos da pessoa com os dados fornecidos pelo usuário
		System.out.print("Digite o e-mail para alterar: ");
		String novoEmail = scanner.nextLine();

		System.out.print("Digite o cargo para alterar: ");
		String novoCargo = scanner.nextLine();

		update.setNome(novoNome);
		update.setEmail(novoEmail);
		update.setCargo(novoCargo);

		// Atualizar as alterações no banco de dados no pessoaRepository
		pessoaRepository.atualizar(update);
		System.out.print("Dados Alterados com sucesso!");
	}

	public void listarPessoas() {
		// Obter a lista de todas as pessoas do banco de dados no pessoaRepository
		List<Pessoa> pessoas = pessoaRepository.listarPessoas();

		// Verificar se existem pessoas cadastradas
		if (pessoas.isEmpty()) {
			System.out.println("Não há pessoas cadastradas.");
		} else {
			System.out.println("Lista de Pessoas:");
			for (Pessoa pessoa : pessoas) {
				System.out.println("ID: " + pessoa.getId());
				System.out.println("Nome: " + pessoa.getNome());
				System.out.println("E-mail: " + pessoa.getEmail());
				System.out.println("Cargo: " + pessoa.getCargo());
			}
		}
	}

	public void excluirPessoa() {
		// Solicitar o ID da pessoa que será excluída
		System.out.print("Digite o ID da pessoa que deseja excluir: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consumir a nova linha após a leitura do número

		// Verificar se a pessoa com o ID fornecido existe no banco de dados
		Pessoa pessoa = pessoaRepository.buscar(id);
		if (pessoa == null) {
			System.out.println("Pessoa com o ID informado não encontrada.");
			return; // Encerrar o método
		}

		// Confirmar a exclusão com o usuário
		System.out.print("Tem certeza que deseja excluir a pessoa " + pessoa.getNome() + "? (S/N): ");
		String confirmacao = scanner.nextLine();

		if (confirmacao.equalsIgnoreCase("S")) {
			// Excluir a pessoa do banco de dados no pessoaRepository
			pessoaRepository.excluir(pessoa.getId());
			System.out.println("Pessoa excluída com sucesso!");
		} else {
			System.out.println("Exclusão cancelada pelo usuário.");
		}
	}
}
