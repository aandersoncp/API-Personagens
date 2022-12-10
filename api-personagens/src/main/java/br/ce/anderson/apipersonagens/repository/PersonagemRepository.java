package br.ce.anderson.apipersonagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ce.anderson.apipersonagens.model.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {
    
}
