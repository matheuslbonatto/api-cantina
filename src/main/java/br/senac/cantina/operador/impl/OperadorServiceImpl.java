package br.senac.cantina.operador.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.cantina.operador.OperadorService;
import br.senac.cantina.operador.dto.CreateOperadorDto;
import br.senac.cantina.operador.dto.UpdateOperadorDto;
import br.senac.cantina.shared.models.Operador;
import br.senac.cantina.shared.repositories.OperadorRepository;

@Service
public class OperadorServiceImpl implements OperadorService {

    private OperadorRepository operadorRepository;

    public OperadorServiceImpl(OperadorRepository operadorRepository) {
        this.operadorRepository = operadorRepository;
    }

    // Salvar um novo Operador
    @Override
    public Operador save(CreateOperadorDto dto) {
        var operador = new Operador(null, dto.nome(), dto.usuario(), dto.senha());
        return this.operadorRepository.save(operador);
    }

    // Listar todos os Operadores
    @Override
    public List<Operador> findAll() {
        return operadorRepository.findAll();
    }

    // Listar o Operador por ID
    @Override
    public Operador findById(Long id) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'findById'");
        return operadorRepository.findById(id).orElse(null);
    }

    // Deletar um Operador por ID
    @Override
    public void deleteById(Long id) {
        operadorRepository.deleteById(id);
    }
    
    // Atualizar senha Operador
    @Override
    public void update(Long id, UpdateOperadorDto dto) {
        // Busca a conta
        Operador operador = operadorRepository.findById(id).get();
        // Valida se a conta existe
        if (operador == null) {
            throw new RuntimeException("Operador Não Encontrado");
        }

        operador.setSenha(dto.senha());
        operadorRepository.save(operador);
    }

}
