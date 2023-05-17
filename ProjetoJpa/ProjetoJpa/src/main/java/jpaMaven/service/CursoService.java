package jpaMaven.service;

import jpaMaven.model.Curso;
import jpaMaven.repository.curso.CursoRepository;
import jpaMaven.repository.curso.CursoRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class CursoService {

    Scanner scanner = new Scanner(System.in);
    private CursoRepository cursoRepository = new CursoRepositoryImpl();

    public void inserirCurso() {
        System.out.print("Digite o nome do curso: ");
        String nome = scanner.nextLine();

        Curso curso = new Curso(null, nome);

        cursoRepository.inserir(curso);
        System.out.print("Dados inseridos com sucesso!");

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

    public void buscarCurso() {
        System.out.print("\nEscolher Curso: \n 1-Básico | 2-Intermediário | 3-Avançado \n");
        long id = scanner.nextInt();
        scanner.nextLine();

        Curso curso = cursoRepository.buscar(id);
        if (curso == null) {
            System.out.println("Curso com o ID informado não encontrada.");
            return;
        }

        System.out.print("Tem certeza que deseja escolher esse curso " + curso.getNome() + "? (S/N): ");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            cursoRepository.buscar(curso.getId());
            System.out.println("Curso selecionado com sucesso!");
        } else {
            System.out.println("Operação cancelada pelo usuário.");
        }
    }

    public void listarCursos() {
        List<Curso> cursos = cursoRepository.listar();

        if (cursos.isEmpty()) {
            System.out.println("Não há cursos cadastradas.");
        } else {
            System.out.println("Lista de Cursos:");
            for (Curso curso : cursos) {
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
