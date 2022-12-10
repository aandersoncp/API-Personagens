package br.ce.anderson.apipersonagens.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.ce.anderson.apipersonagens.model.Personagem;
import br.ce.anderson.apipersonagens.model.exception.ResourceNotFoundException;

@Repository
public class PersonagemRepositoryOld {
    private ArrayList<Personagem> personagens = new ArrayList<Personagem>();
    
    private Integer ultimoId = 0;

    /**
     * Método para retornar uma lista de personagens
     * @return Retorna uma lista de personagens 
     */
    public List<Personagem> obterTodos(){
        return personagens;
    }

    /**
     * Método para retornar um personagem por seu id
     * @param id do personagem a ser buscado
     * @return Returna um personagem caso seja encontrado
     */
    public Personagem obterPorId(int id){
       int contador = personagens.size();
       for(int i = 0; i < contador; i++){
            if(personagens.get(i).getId() == id){
                return personagens.get(i);
            }
       }
       return null;
    }

    /**
     * Método para adicionar um novo personagem
     * @param personagem a ser adicionado
     * @return Returna o personagem que foi adicionado a lista
     */
    public Personagem cadastrar(Personagem personagem){
        ultimoId++;
        personagem.setId(ultimoId);
        personagens.add(personagem);
        return personagem;
    }

    /**
     * Método para deletar personagem por id
     * @param id do personagem a ser deletado
     */
    public void deletar(int id){
        personagens.removeIf(personagem -> personagem.getId() == id);
    }

    /**
     * Método para atualizar um personagem
     * @param personagem a ser atualizado
     * @return Retorna o personagem que foi atualizado
     */
    public Personagem atualizar(Personagem personagem){
        int contador = personagens.size();
       for(int i = 0; i < contador; i++){
            if(personagens.get(i).getId() == personagem.getId()){
                personagens.remove(i);
                personagens.add(personagem);
                return personagem;
            }
       }
       throw new ResourceNotFoundException("Personagem não encontrado");
    }
}
