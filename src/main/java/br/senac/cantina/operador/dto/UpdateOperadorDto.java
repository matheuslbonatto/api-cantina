package br.senac.cantina.operador.dto;

public class UpdateOperadorDto {
 private char nome;
 private char usuario;
 private char senha;


 public UpdateOperadorDto(char nome, char usuario, char senha) {
    this.nome = nome;
    this.usuario = usuario;
    this.senha = senha;
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
