package br.senac.cantina.movimentacao;

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

import br.senac.cantina.movimentacao.dto.CreateMovimentacaoDto;
import br.senac.cantina.movimentacao.dto.UpdateMovimentacaoDto;
import br.senac.cantina.movimentacao.impl.MovimentacaoServiceImpl;
import br.senac.cantina.shared.dto.ErrorBodyDto;
import br.senac.cantina.shared.models.Movimentacao;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    private final MovimentacaoServiceImpl MovimentacaoService;

    public MovimentacaoController(MovimentacaoServiceImpl MovimentacaoService) {
        this.MovimentacaoService = MovimentacaoService;
    }

    // Criar uma nova movimentacao

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CreateMovimentacaoDto dto) {
        try{
            var movimentacao = this.MovimentacaoService.save(dto);
            return ResponseEntity.ok().body(movimentacao);
        }catch (Exception e) {
        return ResponseEntity
        .internalServerError()
        .body(new ErrorBodyDto(true, e.getMessage()));
        }
    }
    

    // GET - Listar as movimentacoes
    @GetMapping
    public List<Movimentacao> getMovimentacao() {
        return MovimentacaoService.findAll();
    }

    // GET - Listar Movimentacao por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getMovimentacaobyId(@PathVariable Long id) {
        var movimantacao = MovimentacaoService.findById(id);
        if (movimantacao == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movimantacao);

    }

    // PATCH - Atualiza parcialmente uma movimentacao
    @PatchMapping("/{id}")
    public ResponseEntity<ErrorBodyDto> updateMovimantacao(@PathVariable Long id, @RequestBody UpdateMovimentacaoDto dto) {
        try{ 
        MovimentacaoService.update(id, dto);
        return ResponseEntity.ok().build();
    }catch (Exception e) {
        return ResponseEntity
        .internalServerError()
        .body(new ErrorBodyDto(true, e.getMessage()));
        }
    }

    // DELETE - Exclusão
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovimantacao(@PathVariable Long id) {
     try{ 
        MovimentacaoService.deleteById(id);
        return ResponseEntity.ok().build();
        }catch (Exception e) {
            return ResponseEntity
            .internalServerError()
            .body(new ErrorBodyDto(true, e.getMessage()));
            }
    }

}