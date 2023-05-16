package Aula_12_04;

public class Candidato {

    public String cpf;
    public String nome;
    public String email;
    public long matricula;
    public String curso;

    public Candidato(String cpf, String nome, String email, long matricula, String curso) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.curso = curso;
    }

    public boolean validacao(){
        if(cpf.length() != 11) {
            return false;
        }
        return true;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Candidato(String nome, String email, long matricula, String curso) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.curso = curso;
    }


}
