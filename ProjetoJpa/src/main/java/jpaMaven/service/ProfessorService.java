package jpaMaven.service;

import jpaMaven.model.Disciplina;
import jpaMaven.model.Professor;
import jpaMaven.repository.disciplina.DisciplinaRepository;
import jpaMaven.repository.disciplina.DisciplinaRepositoryImpl;
import jpaMaven.repository.professor.ProfessorRepository;
import jpaMaven.repository.professor.ProfessorRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class ProfessorService {

    Scanner scanner = new Scanner(System.in);
    private ProfessorRepository professorRepository = new ProfessorRepositoryImpl();

    public void inserirProfessor() {
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();

        Professor professor = new Professor(null, nome);

        professorRepository.inserir(professor);
        System.out.print("Dados inseridos com sucesso!");
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

    public void buscarProfessor() {
        System.out.print("\nEscolher Professor: \n 1-Carlos | 2-Rosana \n");
        long id = scanner.nextInt();

        Professor professor = professorRepository.buscar(id);
        if (professor == null) {
            System.out.println("Professor com o ID informado não encontrado.");
            return;
        }

        String confirmacao = scanner.nextLine();

        if ((confirmacao.equals(1) || confirmacao.equals(2))) {
            professorRepository.buscar(professor.getId());
            System.out.println("Disciplina matriculada com sucesso!");
        } else {
            System.out.println("Operação cancelada pelo usuário.");
        }
    }

    public void listarProfessor() {
        List<Professor> professores = professorRepository.listar();

        if (professores.isEmpty()) {
            System.out.println("Não há professores cadastradas.");
        } else {
            System.out.println("Lista de Professores:");
            for (Professor professor : professores) {
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
