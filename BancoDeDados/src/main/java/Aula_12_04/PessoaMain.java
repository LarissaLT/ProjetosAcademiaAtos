package Aula_12_04;

public class PessoaMain {

    public static void main(String[] args) {
        // Ex 02:
        Pessoa p1 = new Pessoa(); // instanciar uma classe
        p1.nome = "João"; // preenchendo os atributos
        p1.email = "joao@hotmail.com"; // preenchendo os atributos
        p1.cpf = "111.111.111-11"; // preenchendo os atributos

        Pessoa p2 = new Pessoa(); // instanciar uma classe
        p2.nome = "Maria"; // preenchendo os atributos
        p2.email = "maria@hotmail.com"; // preenchendo os atributos
        p2.cpf = "222.222.222-22"; // preenchendo os atributos

        System.out.println("Nome: "+ p1.getNome() + ", Email: " + p1.getEmail() + ", CPF: " + p1.getCpf());
        System.out.println("Nome: "+ p2.getNome() + ", Email: " + p2.getEmail() + ", CPF: " + p2.getCpf());
    }
}
