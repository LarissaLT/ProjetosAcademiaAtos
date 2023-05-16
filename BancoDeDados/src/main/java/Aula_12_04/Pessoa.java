package Aula_12_04;

import java.util.Scanner;

public class Pessoa {

    // Ex 01 - criar os atributos nome, email e cpf
    public String nome;
    public String email;
    public  String cpf;


    //Ex 03:
    // É necessário criar um cosntrutor
    public Pessoa() {}

    //Importar a classe Scanner
    public void definirValores() {
        Scanner leiaScanner = new Scanner(System.in);

        System.out.print("Insira o nome da pessoa: ");
        nome = leiaScanner.nextLine();
        System.out.print("Insira o email da pessoa: ");
        email = leiaScanner.nextLine();
        System.out.print("Insira o CPF da pessoa: ");
        cpf = leiaScanner.nextLine();

        System.out.println("Nome:" + nome + "Email:" + email + "CPF:" +cpf);
    }





    // Para que a aplicação rode no metodo Main é necessário adicionar getters e setters

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
