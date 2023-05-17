package jpaMaven.service;

import jpaMaven.model.Aluno;
import jpaMaven.model.Curso;
import jpaMaven.model.Disciplina;
import jpaMaven.model.Professor;
import jpaMaven.repository.aluno.AlunoRepository;
import jpaMaven.repository.aluno.AlunoRepositoryImpl;
import jpaMaven.repository.curso.CursoRepository;
import jpaMaven.repository.curso.CursoRepositoryImpl;
import jpaMaven.repository.disciplina.DisciplinaRepository;
import jpaMaven.repository.disciplina.DisciplinaRepositoryImpl;
import jpaMaven.repository.professor.ProfessorRepository;
import jpaMaven.repository.professor.ProfessorRepositoryImpl;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlunoService {

    Scanner scanner = new Scanner(System.in);
    private AlunoRepository alunoRepository = new AlunoRepositoryImpl();
    private DisciplinaRepository disciplinaRepository = new DisciplinaRepositoryImpl();
    private CursoRepository cursoRepository = new CursoRepositoryImpl();
    private ProfessorRepository professorRepository = new ProfessorRepositoryImpl();

    public void matricularAluno() {
        // Criar uma nova instância de Aluno com os dados fornecidos
        Aluno aluno = new Aluno();

        // Solicitar os dados da aluno ao usuário
        System.out.print("Digite o nome do aluno: ");
        String input = scanner.nextLine();
        aluno.setNome(input);

        /*------------------------------------------------------------------------*/

        // find all no curso
        List<Disciplina> disciplinas = disciplinaRepository.listar();
        System.out.println("Disciplinas disponíveis:");
        System.out.println("1-Inglês | 2-Espanhol");
        System.out.println("Digite o ID da Disciplina");
        input = scanner.nextLine();

        Long idDisciplina = Long.parseLong(input);

        Disciplina disciplinaEncontrada = disciplinas.stream()
                .filter(e -> e.getId().equals(idDisciplina))
                .findFirst()
                .orElse(null);

        aluno.setDisciplinas(Collections.singletonList(disciplinaEncontrada));

        /*------------------------------------------------------------------------*/

        List<Curso> cursos = cursoRepository.listar();
        System.out.println("Cursos disponíveis:");
        System.out.println("1-Básico | 2-Intermediário | 3-Avançado");
        System.out.print("Digite o ID do Curso: ");
        input = scanner.nextLine();

        Long idCuso = Long.parseLong(input);

        Curso cursoEncontrado = cursos.stream()
                .filter(e -> e.getId().equals(idCuso))
                .findFirst()
                .orElse(null);

        aluno.setCurso(cursoEncontrado);

        /*------------------------------------------------------------------------*/

        List<Professor> professores = professorRepository.listar();
        System.out.println("Professores disponíveis:");
        System.out.println("1- Carlos | 2-Rosana");
        System.out.print("Digite o ID do Professor: ");
        input = scanner.nextLine();

        Long idProfessor = Long.parseLong(input);

        Professor professorEncontrado = professores.stream()
                .filter(e -> e.getId().equals(idProfessor))
                .findFirst()
                .orElse(null);

        aluno.setProfessor(professorEncontrado);

        /*------------------------------------------------------------------------*/

        // Inserir a nova aluno no banco de dados no alunoRepository
        alunoRepository.inserir(aluno);
        System.out.print("Dados inseridos com sucesso! \n");
    }

    public void inserirAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        Aluno aluno = new Aluno(null, nome);

        alunoRepository.inserir(aluno);
        System.out.print("Dados inseridos com sucesso!");

    }

    public void alterarAluno() {
        // Solicitar o ID da aluno que será alterada
        System.out.print("Digite o id que deseja alterar: ");
        long id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha após a leitura do número

        // Buscar a aluno com o ID fornecido no alunoRepository
        Aluno update = alunoRepository.buscar(id);

        if (update != null) {

            // Modificar os atributos da aluno com os dados fornecidos pelo usuário
            System.out.print("Digite o nome para alterar: ");
            String novoNome = scanner.nextLine();

            update.setNome(novoNome);

            // Atualizar as alterações no banco de dados no alunoRepository
            alunoRepository.atualizar(update);
            System.out.print("Dados Alterados com sucesso!");

        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

        public void listarAlunos () {
            // Obter a lista de todas as alunos do banco de dados no alunoRepository
            List<Aluno> alunos = alunoRepository.listar();

            // Verificar se existem alunos cadastradas
            if (alunos.isEmpty()) {
                System.out.println("Não há alunos cadastradas.");
            } else {
                System.out.println("Lista de Alunos:");
                for (Aluno aluno : alunos) {
                    System.out.println("ID: " + aluno.getId());
                    System.out.println("Nome: " + aluno.getNome());
                }
            }
        }

        public void excluirAluno () {
            // Solicitar o ID da aluno que será excluída
            System.out.print("Digite o ID da aluno que deseja excluir: ");
            long id = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha após a leitura do número

            // Verificar se a aluno com o ID fornecido existe no banco de dados
            Aluno aluno = alunoRepository.buscar(id);
            if (aluno == null) {
                System.out.println("Aluno com o ID informado não encontrada.");
                return; // Encerrar o método
            }

            // Confirmar a exclusão com o usuário
            System.out.print("Tem certeza que deseja excluir a aluno " + aluno.getNome() + "? (S/N): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                // Excluir aluno do banco de dados no alunoRepository
                alunoRepository.excluir(aluno.getId());
                System.out.println("Aluno excluído com sucesso!");
            } else {
                System.out.println("Exclusão cancelada pelo usuário.");
            }
        }
    }

