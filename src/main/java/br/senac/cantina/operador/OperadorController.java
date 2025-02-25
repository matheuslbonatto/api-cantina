package br.senac.cantina.operador;

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

import br.senac.cantina.operador.dto.CreateOperadorDto;
import br.senac.cantina.operador.dto.UpdateOperadorDto;
import br.senac.cantina.operador.impl.OperadorServiceImpl;
import br.senac.cantina.shared.models.Operador;

@RestController
@RequestMapping("/operadores")
public class OperadorController {

    private final OperadorServiceImpl operadorService;

    public OperadorController(OperadorServiceImpl operadorService) {
        this.operadorService = operadorService;
    }

    // Criar um novo Operador
    @PostMapping
    public ResponseEntity<Operador> save(@RequestBody CreateOperadorDto dto) {
        var saved = this.operadorService.save(dto);
        return ResponseEntity.ok(saved);
    }

    // GET - Listar os Operadores
    @GetMapping("")
    public List<Operador> getOperador() {
        return operadorService.findAll();
    }

    // GET - Listar Operador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOperdarbyId(@PathVariable Long id) {
        var operador = operadorService.findById(id);
        if (operador == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(operador);

    }

    // PATCH - Atualiza parcialmente uma conta
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateOperador(@PathVariable Long id, @RequestBody UpdateOperadorDto dto) {
        operadorService.update(id, dto);
        return ResponseEntity.ok().build();
    }

    // DELETE - Exclusão
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOperador(@PathVariable Long id) {
        operadorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
