package com.spring.jpa_spring;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Data
public class Usuario extends BaseEntity {

    @CPF
    @NotBlank(message = "O campo CPF é obrigatório")
    private String cpf;
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;
    @Email
    @NotBlank(message = "O campo email é obrigatório")
    private String email;
    @Embedded
    private Endereco endereco;

    public void setId(Long id){
        super.id = id;
    }

}
