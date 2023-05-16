package Aula_12_04;

public class Aluno {

    public String nome;
    public String email;
    public long matricula;

    public Aluno(String nome, long matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public Aluno(String nome, String email, long matricula) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
}
