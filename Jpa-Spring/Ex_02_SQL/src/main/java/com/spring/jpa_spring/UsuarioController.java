package com.spring.jpa_spring;

import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PrePersist
    /* permite que você especifique um método na classe de entidade que será chamado automaticamente
    antes da persistência ocorrer. Isso é útil para realizar operações ou configurações adicionais na
    entidade antes de ser salva no banco de dados.
     */
    public Usuario cadastrar(@RequestBody Usuario dados){
        return service.cadastrar(dados);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualzar(@RequestBody Usuario dados, @PathVariable Long id){
        return service.atualizar(dados, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }


}
