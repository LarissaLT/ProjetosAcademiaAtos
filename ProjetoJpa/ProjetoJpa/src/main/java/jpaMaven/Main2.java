package jpaMaven;

import jpaMaven.model.Aluno;
import jpaMaven.repository.aluno.AlunoRepository;
import jpaMaven.repository.aluno.AlunoRepositoryImpl;
import jpaMaven.service.AlunoService;
import jpaMaven.service.CursoService;
import jpaMaven.service.DisciplinaService;
import jpaMaven.service.ProfessorService;
import jpaMaven.z.application.AlunoMain;

import java.util.List;
import java.util.Scanner;

public class Main2 {

    Scanner scanner = new Scanner(System.in);
    private AlunoRepository alunoRepository = new AlunoRepositoryImpl();
    private AlunoService alunoService;
    private CursoService cursoService;
    private DisciplinaService disciplinaService;
    private ProfessorService professorService;


    public static void main(String[] args) {
        Main2 principal = new Main2();
        principal.executar();
    }

    public void executar() {

        this.alunoService = new AlunoService();


        this.cursoService = new CursoService();



        boolean continuarRodando = true;

        // Executar a lógica com base na opção escolhida
        while (continuarRodando) {
            System.out.print("Digite a opção desejada: \n 1-Gerenciar Aluno | 2-Gerenciar Curso | 0-Sair \n ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "0":
                    continuarRodando = false;
                    break;
                case "1":
                    gerenciarAluno();
                    break;
                case "2":
                    gerenciarCurso();
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

    public void gerenciarAluno() {
        boolean continuarRodando = true;
        while (continuarRodando) {
            System.out.print("Digite as opções desejadas: \n 1-Inserir Aluno | 2-Alterar Aluno | 3-Visualizar Aluno | 4-Deletar Aluno | 9-Voltar ao menu principal \n ");
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

    public void gerenciarCurso(){
        boolean continuarRodando = true;
        while (continuarRodando) {
            System.out.print("Digite as opções desejadas: \n 1-Inserir Curso, 2-Alterar Curso, 3-Visualizar Curso, 4-Deletar Curso: \n ");
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
}


