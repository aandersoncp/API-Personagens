package br.ce.anderson.apipersonagens.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ce.anderson.apipersonagens.model.Personagem;
import br.ce.anderson.apipersonagens.model.exception.ResourceNotFoundException;
import br.ce.anderson.apipersonagens.repository.PersonagemRepository;
import br.ce.anderson.apipersonagens.shared.PersonagemDTO;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public List<PersonagemDTO> obterTodos(){
        List<Personagem> personagens = personagemRepository.findAll();
        return personagens.stream()
        .map(personagem -> new ModelMapper().map(personagem, PersonagemDTO.class))
        .collect(Collectors.toList());
    }

    public Optional<PersonagemDTO> obterPorId(Integer id){
        Optional<Personagem> p = personagemRepository.findById(id);
        if(p.isEmpty()){
            throw new ResourceNotFoundException("Personagem não encontrado.");
        }
        PersonagemDTO personagem = new ModelMapper().map(p.get(), PersonagemDTO.class);
        return Optional.of(personagem);

        //throw new ResourceNotFoundException("Personagem não encontrado");
    }

    public PersonagemDTO cadastrar(PersonagemDTO personagemDTO){
        Personagem personagem = new ModelMapper().map(personagemDTO, Personagem.class);
        Personagem personagemRetorno = personagemRepository.save(personagem);
        PersonagemDTO personagemDto = new ModelMapper().map(personagemRetorno, PersonagemDTO.class);
        return personagemDto;
    }

    public void deletar(Integer id){
        Optional<Personagem> p = personagemRepository.findById(id);
        if(p.isEmpty()){
           throw new ResourceNotFoundException("Personagem com id = " + id + "não encontrado.");
        }
        personagemRepository.deleteById(id);
    }

    public PersonagemDTO atualizar(Integer id, PersonagemDTO p){

        //Fazer a validação do campo id aqui
        p.setId(id);
        deletar(id);
        Personagem personagem = new ModelMapper().map(p, Personagem.class);
        return new ModelMapper().map(personagemRepository.save(personagem), PersonagemDTO.class); 
    }

    
}
