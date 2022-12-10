package br.ce.anderson.apipersonagens.model;

public class Personagem {

    private int id;

    private String nome;

    private String filme_serie;

    private int ano_estreia;

    private String observacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFilme_serie() {
        return filme_serie;
    }

    public void setFilme_serie(String filme_serie) {
        this.filme_serie = filme_serie;
    }

    public int getAno_estreia() {
        return ano_estreia;
    }

    public void setAno_estreia(int ano_estreia) {
        this.ano_estreia = ano_estreia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    
}
