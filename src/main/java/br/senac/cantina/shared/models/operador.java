package br.senac.cantina.shared.models;

public class operador {
    // Criar os atributos para a tabela operador
 private int id;
 private char nome;
 private char usuario;
 private char senha;


// Criar um método construtor com todos os atributos
public operador(int id, char nome, char usuario) {
    this.id = id;
    this.nome = nome;
    this.usuario = usuario;
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
public char getUsuario() {
    return usuario;
}
public void setUsuario(char usuario) {
    this.usuario = usuario;
}
public char getSenha() {
    return senha;
}
public void setSenha(char senha) {
    this.senha = senha;
}

    
}
