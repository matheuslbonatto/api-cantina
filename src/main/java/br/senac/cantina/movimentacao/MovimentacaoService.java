package br.senac.cantina.movimentacao;

import br.senac.cantina.shared.models.Movimentacao;

import java.util.List;

import br.senac.cantina.movimentacao.dto.CreateMovimentacaoDto;
import br.senac.cantina.movimentacao.dto.UpdateMovimentacaoDto;

public interface MovimentacaoService {

    public Movimentacao save (CreateMovimentacaoDto dto);

    public List<Movimentacao> findAll();

    public Movimentacao findById(Long id);

    public void deleteById(Long id);
    
    public void update(Long id, UpdateMovimentacaoDto dto);
} 