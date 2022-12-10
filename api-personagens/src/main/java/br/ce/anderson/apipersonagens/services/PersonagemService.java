package br.ce.anderson.apipersonagens.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ce.anderson.apipersonagens.model.Personagem;
import br.ce.anderson.apipersonagens.repository.PersonagemRepositoryOld;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepositoryOld repositoryOld;

    public List<Personagem> obterTodos(){
        return repositoryOld.obterTodos();
    }

    public Personagem obterPorId(Integer id){
        return repositoryOld.obterPorId(id);
    }

    public Personagem cadastrar(Personagem p){
        return repositoryOld.cadastrar(p);
    }

    public void deletar(Integer id){
        repositoryOld.deletar(id);
    }

    public Personagem atualizar(Integer id, Personagem p){

        //Fazer a validação do campo id aqui
        p.setId(id);
        return repositoryOld.atualizar(p);
    }

    
}
