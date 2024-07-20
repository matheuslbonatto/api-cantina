package br.senac.cantina.produto.dto;

import java.time.LocalDateTime;

public record CreateProdutoDto (
    String nome,
    String descricao,
    double preco,
    float quantidade,
    LocalDateTime dataHora){

}

