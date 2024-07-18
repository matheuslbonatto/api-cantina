package br.senac.cantina.operador;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.cantina.operador.dto.CreateOperadorDto;
import br.senac.cantina.operador.impl.OperadorServiceImpl;
import br.senac.cantina.shared.models.operador;

@RestController
@RequestMapping("/operador")
public class OperadorController {
 
    private final OperadorServiceImpl operadorService;

    public OperadorController (OperadorServiceImpl operadorService, OperadorServiceImpl operadorService2) {
        this.operadorService = operadorService;
        }

    // Criar um novo Operador
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CreateOperadorDto dto) {
        var saved = this.operadorService.save(dto);
        return ResponseEntity.ok(saved);
    }
   
    // GET - Listar os Operadores 
    @GetMapping ("")
    public List<operador> getOperador() {
        return OperadorService.findAll();
    }

    //GET - Listar produtos por ID
    @GetMapping ("/{id}")
    public ResponseEntity<Object> getOperdarbyId(@PathVariable Long id) {
        var operador = operadorService.findById(id);
        if (operador == null){
            return ResponseEntity.notFound().build();
        } 
        
        return ResponseEntity.ok().body(operador);
    
    }

}
