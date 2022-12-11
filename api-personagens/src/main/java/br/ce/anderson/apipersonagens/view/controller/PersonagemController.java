package br.ce.anderson.apipersonagens.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import br.ce.anderson.apipersonagens.shared.PersonagemDTO;
import br.ce.anderson.apipersonagens.view.models.PersonagemRequest;
import br.ce.anderson.apipersonagens.view.models.PersonagemResponse;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {
    
    @Autowired
    private PersonagemService personagemService;

    @GetMapping
    public ResponseEntity<List<PersonagemResponse>> obterTodos(){
        ModelMapper mapper = new ModelMapper();
        List<PersonagemDTO> listaPersonagem = personagemService.obterTodos();
        List<PersonagemResponse> resposta =  listaPersonagem.stream()
        .map(personagemDTO -> mapper.map(personagemDTO, PersonagemResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PersonagemResponse>> obterPorId(@PathVariable Integer id){
        ModelMapper mapper = new ModelMapper();
        Optional<PersonagemDTO> personagemDTO = personagemService.obterPorId(id);
        PersonagemResponse resposta = mapper.map(personagemDTO.get(), PersonagemResponse.class);
        return new ResponseEntity<>(Optional.of(resposta), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonagemResponse> cadastrar(@RequestBody PersonagemRequest p){
        ModelMapper mapper = new ModelMapper();
        PersonagemDTO dto = mapper.map(p, PersonagemDTO.class);
        return new ResponseEntity<>(mapper.map(personagemService.cadastrar(dto), PersonagemResponse.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        personagemService.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonagemResponse> atualizar(@PathVariable Integer id, @RequestBody PersonagemRequest p){
        ModelMapper mapper = new ModelMapper();
        PersonagemDTO dto = mapper.map(p, PersonagemDTO.class);
        return new ResponseEntity<>(mapper.map(personagemService.atualizar(id, dto), PersonagemResponse.class), HttpStatus.OK);
    }
}
