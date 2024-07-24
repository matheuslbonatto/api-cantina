package br.senac.cantina.produto.dto;

import java.time.LocalDateTime;

public record CreateProdutoDto (
    String nome,
    String descricao,
    Double preco,
    Float quantidade,
    LocalDateTime created_at,
    LocalDateTime updated_at){

}

