package br.senac.cantina.movimentacao.dto;

public record CreateMovimentacaoDto(
                long produtoId,
                long quantidade,
                long operadorId,
                Character tipoRegistro) {

}