package Aula_12_04;

public class AlunoMain {

    public static void main(String[] args) {
        Aluno a1 = new Aluno("Jose", 111111);

        Aluno a2 = new Aluno("Ana", 222222);

        Aluno a3 = new Aluno("Carlos", "carlos@hotmail.com", 333333 );



        System.out.println("Nome: "+ a1.getNome() + ", Email: " + a1.getEmail() + ", Matrícula: " + a1.getMatricula());
        System.out.println("Nome: "+ a2.getNome() + ", Email: " + a2.getEmail() + ", Matrícula: " + a2.getMatricula());
        System.out.println("Nome: "+ a3.getNome() + ", Email: " + a3.getEmail() + ", Matrícula: " + a3.getMatricula());

    }

    }

