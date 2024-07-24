package br.senac.cantina.shared.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table ("produtos")
public class Produto {
    // Criar os atributos para a tabela Produto
    @Id
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private float quantidade;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    
    public Produto(Long id, String nome, String descricao, double preco, float quantidade, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public float getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
    public LocalDateTime getcreated_at() {
        return created_at;
    }
    public void setcreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
    public LocalDateTime getupdated_at() {
        return updated_at;
    }
    public void setupdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}