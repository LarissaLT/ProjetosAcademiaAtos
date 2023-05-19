package jpaMaven;

import jpaMaven.repository.aluno.AlunoRepository;
import jpaMaven.repository.aluno.AlunoRepositoryImpl;
import jpaMaven.service.AlunoService;
import jpaMaven.service.CursoService;
import jpaMaven.service.DisciplinaService;
import jpaMaven.service.ProfessorService;

import java.util.Scanner;

public class Application {

    Scanner scanner = new Scanner(System.in);
    private AlunoRepository alunoRepository = new AlunoRepositoryImpl();
    private AlunoService alunoService;
    private CursoService cursoService;
    private DisciplinaService disciplinaService;
    private ProfessorService professorService;


    public static void main(String[] args) {
        Application principal = new Application();
        principal.executar();
    }

    public void executar() {

        this.alunoService = new AlunoService();
        this.cursoService = new CursoService();
        this.disciplinaService = new DisciplinaService();
        this.professorService = new ProfessorService();

        boolean continuarRodando = true;

        // Executar a lógica com base na opção escolhida
        while (continuarRodando) {
            System.out.print("Digite a opção desejada: \n 1-Matrícula | 2-Visualizar Disciplinas | 3-Visualizar Cursos | 4-Visualizar Professores | 0-Sair \n ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "0":
                    continuarRodando = false;
                    break;
                case "1":
                    gerenciarMatricula();
                    break;
                case "2":
                    disciplinaService.listarDisciplina();
                    break;
                case "3":
                    cursoService.listarCursos();
                    break;
                case "4":
                    professorService.listarProfessor();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        }
        // Fechar a conexão com o banco de dados e encerrar o scanner
        scanner.close();

        alunoRepository.fecharConexao();
    }

    public void gerenciarMatricula() {
        boolean continuarRodando = true;
        while (continuarRodando) {
            System.out.print("\nDigite a opção desejada: \n 1-Matricular Alunos | 2-Gerenciar Alunos | 3-Gerenciar Disciplinas | 4-Gerenciar Cursos | 5-Gerenciar Professores | 9-Voltar ao menu anterior \n ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    alunoService.matricularAluno();
                    break;
                case "2":
                    gerenciarAluno();
                    break;
                case "3":
                    gerenciarDisciplina();
                    break;
                case "4":
                    gerenciarCurso();
                    break;
                case "5":
                    gerenciarProfessor();
                    break;
                case "6":
                    alunoService.excluirAluno();
                    break;
                case "9":
                    continuarRodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public void gerenciarAluno(){
        boolean continuarRodando = true;
        while (continuarRodando) {
            System.out.print("\nDigite as opções desejadas: \n 1-Criar Aluno | 2-Editar Aluno | 3-Visualizar Alunos | 4-Deletar Aluno | 9-Voltar ao meu anterior \n ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    alunoService.inserirAluno();
                    break;
                case "2":
                    alunoService.alterarAluno();
                    break;
                case "3":
                    alunoService.listarAlunos();
                    break;
                case "4":
                    alunoService.excluirAluno();
                    break;
                case "9":
                    continuarRodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public void gerenciarDisciplina(){
        boolean continuarRodando = true;
        while (continuarRodando) {
            System.out.print("\nDigite as opções desejadas: \n 1-Criar Disciplina | 2-Editar Disciplina | 3-Visualizar Disciplinas | 4-Deletar Disciplina | 9-Voltar ao menu anterior \n ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    disciplinaService.inserirDisciplina();
                    break;
                case "2":
                    disciplinaService.alterarDisciplina();
                    break;
                case "3":
                    disciplinaService.listarDisciplina();
                    break;
                case "4":
                    disciplinaService.excluirDisciplina();
                    break;
                case "9":
                    continuarRodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public void gerenciarCurso(){
        boolean continuarRodando = true;
        while (continuarRodando) {
            System.out.print("\nDigite as opções desejadas: \n 1-Criar Curso | 2-Editar Curso | 3-Visualizar Curso | 4-Deletar Curso | 9-Voltar ano menu anterior \n ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    cursoService.inserirCurso();
                    break;
                case "2":
                    cursoService.alterarCurso();
                    break;
                case "3":
                    cursoService.listarCursos();
                    break;
                case "4":
                    cursoService.excluirCurso();
                    break;
                case "9":
                    continuarRodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public void gerenciarProfessor(){
        boolean continuarRodando = true;
        while (continuarRodando) {
            System.out.print("\nDigite as opções desejadas: \n 1-Criar Professor | 2-Editar Professor | 3-Visualizar Professor | 4-Deletar Professor | 9-Voltar ao menu anterior \n ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    professorService.inserirProfessor();
                    break;
                case "2":
                    professorService.alterarProfesssor();
                    break;
                case "3":
                    professorService.listarProfessor();
                    break;
                case "4":
                    professorService.excluirProfessor();
                    break;
                case "9":
                    continuarRodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}


