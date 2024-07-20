package br.senac.cantina.produto;

import java.util.List;

import br.senac.cantina.produto.dto.CreateProdutoDto;
import br.senac.cantina.produto.dto.UpdateProdutoDto;
import br.senac.cantina.shared.models.Produto;

public interface ProdutoService {

    public Produto save(CreateProdutoDto dto);
    
    public List<Produto> findAll();

    public void update(Long id, UpdateProdutoDto dto);
    
    public Produto findById(Long id);

    public void deleteById(Long id);
}