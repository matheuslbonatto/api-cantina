package br.senac.cantina.shared.models;

import java.time.LocalDateTime;

public class Movimentacao {
 private int id;
 private long produtoId;
 private long quantidade;
 private LocalDateTime dataHora;
 private long operadorId;
 private char tipoRegistro;

 
 public Movimentacao(int id, long produtoId, long quantidade, LocalDateTime dataHora, long operadorId,
        char tipoRegistro) {
    this.id = id;
    this.produtoId = produtoId;
    this.quantidade = quantidade;
    this.dataHora = dataHora;
    this.operadorId = operadorId;
    this.tipoRegistro = tipoRegistro;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public long getProdutoId() {
    return produtoId;
}
public void setProdutoId(long produtoId) {
    this.produtoId = produtoId;
}
public long getQuantidade() {
    return quantidade;
}
public void setQuantidade(long quantidade) {
    this.quantidade = quantidade;
}
public LocalDateTime getDataHora() {
    return dataHora;
}
public void setDataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
}
public long getOperadorId() {
    return operadorId;
}
public void setOperadorId(long operadorId) {
    this.operadorId = operadorId;
}
public char getTipoRegistro() {
    return tipoRegistro;
}
public void setTipoRegistro(char tipoRegistro) {
    this.tipoRegistro = tipoRegistro;
}
 
}
