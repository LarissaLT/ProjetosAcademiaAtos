package jpaMaven.service;

import jpaMaven.model.Curso;
import jpaMaven.model.Disciplina;
import jpaMaven.repository.curso.CursoRepository;
import jpaMaven.repository.curso.CursoRepositoryImpl;
import jpaMaven.repository.disciplina.DisciplinaRepository;
import jpaMaven.repository.disciplina.DisciplinaRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class DisciplinaService {

    Scanner scanner = new Scanner(System.in);
    private DisciplinaRepository disciplinaRepository = new DisciplinaRepositoryImpl();

    public void inserirDisciplina() {
        System.out.print("Digite o nome do disciplina: ");
        String nome = scanner.nextLine();

        Disciplina disciplina = new Disciplina(null, nome);

        disciplinaRepository.inserir(disciplina);
        System.out.print("Dados inseridos com sucesso!");
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

    public void buscarDisciplina() {
        System.out.print("\nEscolher Disciplina: \n 1-Inglês | 2-Espanhol \n");
        long id = scanner.nextInt();

        Disciplina disciplina = disciplinaRepository.buscar(id);
        if (disciplina == null) {
            System.out.println("Disciplina com o ID informado não encontrado.");
         return;
        }

        String confirmacao = scanner.nextLine();

        if ((confirmacao.equals(1) || confirmacao.equals(2))) {
            disciplinaRepository.buscar(disciplina.getId());
            System.out.println("Disciplina matriculada com sucesso!");
        } else {
            System.out.println("Operação cancelada pelo usuário.");
        }
    }

    public void listarDisciplina() {
        List<Disciplina> disciplinas = disciplinaRepository.listar();

        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas cadastradas.");
        } else {
            System.out.println("Lista de Disciplinas:");
            for (Disciplina disciplina : disciplinas) {
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
