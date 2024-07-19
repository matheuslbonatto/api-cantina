package br.senac.cantina.shared.models;

import java.time.LocalDateTime;

public class Produto {
    // Criar os atributos para a tabela Produto
    private int id;
    private char nome;
    private char descricao;
    private double preco;
    private float quantidade;
    private LocalDateTime dataHora;
    
    
     // Criar um método construtor com todos os atributos
    public Produto(int id, char nome, char descricao, double preco, float quantidade, LocalDateTime dataHora) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.dataHora = dataHora;
    }

    // Criar os getters e setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public char getNome() {
        return nome;
    }
    public void setNome(char nome) {
        this.nome = nome;
    }
    public char getDescricao() {
        return descricao;
    }
    public void setDescricao(char descricao) {
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
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    
    
    
}