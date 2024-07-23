package br.senac.cantina.produto;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.cantina.operador.dto.UpdateOperadorDto;
import br.senac.cantina.produto.dto.CreateProdutoDto;
import br.senac.cantina.produto.dto.UpdateProdutoDto;
import br.senac.cantina.produto.impl.ProdutoServiceImpl;
import br.senac.cantina.shared.models.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoServiceImpl produtoService;

    public ProdutoController(ProdutoServiceImpl produtoService) {
        this.produtoService = produtoService;
        
    }
    
//Cria um novo Produto
@PostMapping
    public ResponseEntity<Object> save(@RequestBody CreateProdutoDto dto){
        var saved = this.produtoService.save(dto);
        return ResponseEntity.ok(saved);
    }

// GET - Listar Produtos
@GetMapping
    public List<Produto> getProduto(){
        return produtoService.findAll();
}

// GET - Listar produto por ID
@GetMapping("/{id}")
public ResponseEntity<Produto> getProdutoById(@PathVariable Long id){
    var produto = produtoService.findById(id);
     if (produto == null) {
         return ResponseEntity.notFound().build();
     }

    return ResponseEntity.ok(produto);
}

// PATCH - Atualiza parcialmente um produto
@PatchMapping("/{id}")
public ResponseEntity<String> updateProduto(@PathVariable Long id, @RequestBody UpdateProdutoDto dto){
    produtoService.update(id, dto);
    return ResponseEntity.ok().build();
}

//DELETE - Exclusão de Produto
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteProduto(@PathVariable Long id){
    produtoService.deleteById(id);
    return ResponseEntity.ok().build();   
}

}    

