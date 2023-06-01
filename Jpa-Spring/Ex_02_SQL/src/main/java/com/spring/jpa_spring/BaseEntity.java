package com.spring.jpa_spring;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected LocalDate dataCriacao;
    protected LocalDate dataUpdate;

    @PrePersist
    public void prePersist() {
        dataCriacao = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        dataUpdate = LocalDate.now();
    }

}
