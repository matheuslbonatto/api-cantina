package br.senac.cantina.movimentacao.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.senac.cantina.movimentacao.MovimentacaoRepository;
import br.senac.cantina.movimentacao.MovimentacaoService;
import br.senac.cantina.movimentacao.dto.CreateMovimentacaoDto;
import br.senac.cantina.movimentacao.dto.UpdateMovimentacaoDto;
import br.senac.cantina.movimentacao.types.TipoRegistroEnum;
import br.senac.cantina.shared.models.Movimentacao;
import br.senac.cantina.shared.models.Produto;
import br.senac.cantina.shared.repositories.ProdutoRepository;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {

    private MovimentacaoRepository movimentacaoRepository;
     private final ProdutoRepository produtoRepository;

    public MovimentacaoServiceImpl(MovimentacaoRepository movimentacaoRepository,  ProdutoRepository produtoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.produtoRepository = produtoRepository;
    }

    // Salvar uma nova Movimentacao
    @Override
    public Movimentacao save(CreateMovimentacaoDto dto) {
      // Procurar o produto e validar se ele existe   
      Optional<Produto> produtoOptional = produtoRepository.findById(dto.produtoId());
        if (produtoOptional.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");  
        }

        Produto produto = produtoOptional.get();
        if (dto.tipoRegistro().equals(TipoRegistroEnum.SAIDA.getValue())&& produto.getQuantidade() < dto.quantidade()) {
            throw new RuntimeException("Quantidade de saida maior que a existente");
           
        }
 
        if(dto.tipoRegistro().equals(TipoRegistroEnum.ENTRADA.getValue())){
            produto.setQuantidade(produto.getQuantidade() + dto.quantidade());
        }else if (dto.tipoRegistro().equals(TipoRegistroEnum.SAIDA.getValue())) {
            produto.setQuantidade(produto.getQuantidade() - dto.quantidade());
           
        }
 
        produtoRepository.save(produto);
 
        Movimentacao movimentacao = new Movimentacao(null, dto.produtoId(), dto.quantidade(),
                dto.operadorId(), dto.tipoRegistro(),
                LocalDateTime.now(), LocalDateTime.now());
        return this.movimentacaoRepository.save(movimentacao);
    }

    // Listar todas as movimentaçoes
    @Override
    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    @Override
    public Movimentacao findById(Long id) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'findById'");
        return movimentacaoRepository.findById(id).orElse(null);
    }

    // Deletar um Operador por ID
    @Override
    public void deleteById(Long id) {
        movimentacaoRepository.deleteById(id);
    }

    @Override
    public void update(Long id, UpdateMovimentacaoDto dto) {
        // Busca uma movimentacao
        Movimentacao movimentacao = movimentacaoRepository.findById(id).get();
        // Valida se a movimentacao existe
        if (movimentacao == null) {
            throw new RuntimeException("Movimentação Não Encontrado");
        }

        movimentacao.setQuantidade(dto.quantidade());
        movimentacaoRepository.save(movimentacao);
    }

}