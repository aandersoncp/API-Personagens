package br.ce.anderson.apipersonagens.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ce.anderson.apipersonagens.model.Personagem;
import br.ce.anderson.apipersonagens.repository.PersonagemRepository;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public List<Personagem> obterTodos(){
        return personagemRepository.findAll();
    }

    public Optional<Personagem> obterPorId(Integer id){
        return personagemRepository.findById(id);
    }

    public Personagem cadastrar(Personagem p){
        return personagemRepository.save(p);
    }

    public void deletar(Integer id){
        personagemRepository.deleteById(id);
    }

    public Personagem atualizar(Integer id, Personagem p){

        //Fazer a validação do campo id aqui
        p.setId(id);
        personagemRepository.deleteById(id);
        return personagemRepository.saveAndFlush(p);
    }

    
}
