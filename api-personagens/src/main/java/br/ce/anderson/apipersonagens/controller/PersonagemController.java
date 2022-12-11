package br.ce.anderson.apipersonagens.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ce.anderson.apipersonagens.model.Personagem;
import br.ce.anderson.apipersonagens.services.PersonagemService;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {
    
    @Autowired
    private PersonagemService personagemService;

    @GetMapping
    public List<Personagem> obterTodos(){
        return personagemService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Personagem> obterPorId(@PathVariable Integer id){
        return personagemService.obterPorId(id);
    }

    @PostMapping
    public Personagem cadastrar(@RequestBody Personagem p){
        return personagemService.cadastrar(p);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        personagemService.deletar(id);
        return "Personagem com id = " + id + " foi deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Personagem atualizar(@PathVariable Integer id, @RequestBody Personagem p){

        return personagemService.atualizar(id, p);
    }
}
