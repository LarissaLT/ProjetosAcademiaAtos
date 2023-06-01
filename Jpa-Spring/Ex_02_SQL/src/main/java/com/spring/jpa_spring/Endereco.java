package com.spring.jpa_spring;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class Endereco {

    private String rua;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
}
