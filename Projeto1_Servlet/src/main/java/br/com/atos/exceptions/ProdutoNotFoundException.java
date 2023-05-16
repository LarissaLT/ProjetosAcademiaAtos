package br.com.atos.exceptions;

public class ProdutoNotFoundException extends Exception {

    public ProdutoNotFoundException(String mensagem){
        super(mensagem);
    }

    public ProdutoNotFoundException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }


}
