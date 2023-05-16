package br.com.atos.exceptions;

public class BancoDadosException extends Exception{

    public BancoDadosException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }


}
