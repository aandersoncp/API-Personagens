package br.ce.anderson.apipersonagens.view.models;

public class PersonagemResponse {
    
    private Integer id;

    private String nome;

    private String filme_serie;

    private Integer ano_estreia;

    private String observacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAno_estreia() {
        return ano_estreia;
    }

    public void setAno_estreia(Integer ano_estreia) {
        this.ano_estreia = ano_estreia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
