package br.senac.cantina.produto.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import br.senac.cantina.produto.ProdutoService;
import br.senac.cantina.produto.dto.CreateProdutoDto;
import br.senac.cantina.produto.dto.UpdateProdutoDto;

import br.senac.cantina.shared.models.Produto;
import br.senac.cantina.shared.repositories.ProdutoRepository;


@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    //Salvar um novo Produto
    @Override
    public Produto save(CreateProdutoDto dto) {
       var produto= new Produto(null, dto.nome(), dto.descricao(), dto.preco(),dto.quantidade(),LocalDateTime.now());
       return this.produtoRepository.save(produto);
    }


    //Listar todos os Produtos    
    @Override
    public List<Produto> findAll() {
       return produtoRepository.findAll();
    }


    // Listar o Produto por ID
    @Override
    public Produto findById(Long id) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'findById'");
        return produtoRepository.findById(id).orElse(null);
    }

    //Deletar Produto por ID
    @Override
    public void deleteById(Long id) {
        Produto produto = produtoRepository.findById(id).get();
        if (produto == null) {
            throw new RuntimeException("Produto não encontrado");    
        }
        if (produto.getQuantidade() > 0) {
            throw new RuntimeException("Produto com saldo não pode ser excluido"); 
        } 
           produtoRepository.deleteById(id);  
    }

    //Atualizar Produto
    @Override
    public void update(Long id, UpdateProdutoDto dto) {
       //Buscar Produto
       Produto produto = produtoRepository.findById(id).get();
       //Validar se o produto existe
       if (produto == null) {
        throw new RuntimeException("Produto Não Encontrado");
        }

        produto.setPreco(dto.preco());
        produtoRepository.save(produto);
        
    }


}