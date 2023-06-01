package com.spring.jpa_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario cadastrar(Usuario dados){
        if (repository.existsByCpf(dados.getCpf())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já registrado");
        }
        return repository.save(dados);
    }

    public List<Usuario> listar(){
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id){
        Optional<Usuario> op = repository.findById(id);
                Usuario usuario = op.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        return usuario;
    }

    public Usuario atualizar(Usuario dados, Long id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        dados.setId(id);
        Usuario atualizado = repository.save(dados);

        return atualizado;
    }

    public void deletar(Long id){
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        repository.deleteById(id);
    }

}
