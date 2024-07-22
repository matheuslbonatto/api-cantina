package br.senac.cantina.produto.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.cantina.operador.dto.CreateOperadorDto;
import br.senac.cantina.produto.ProdutoService;
import br.senac.cantina.produto.dto.CreateProdutoDto;
import br.senac.cantina.produto.dto.UpdateProdutoDto;
import br.senac.cantina.shared.models.Operador;
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
       var produto= new Produto(null, dto.nome(), dto.descricao(), dto.preco(),dto.quantidade(), null);
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