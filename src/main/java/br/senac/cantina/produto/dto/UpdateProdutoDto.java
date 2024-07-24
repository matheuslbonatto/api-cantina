package br.senac.cantina.produto.dto;

public record UpdateProdutoDto (
    String nome,
    String descricao,
    Double preco,
    Float quantidade){
}
