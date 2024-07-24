package br.senac.cantina.shared.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("movimentacoes")
public class Movimentacao {
    @Id
    private Long id;
    private Long produtoId;
    private Long quantidade;
    private Long operadorId;
    private Character tipoRegistro;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Movimentacao(Long id, Long produtoId, Long quantidade, Long operadorId, char tipoRegistro,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.operadorId = operadorId;
        this.tipoRegistro = tipoRegistro;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Long getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(Long operadorId) {
        this.operadorId = operadorId;
    }

    public char getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(char tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}