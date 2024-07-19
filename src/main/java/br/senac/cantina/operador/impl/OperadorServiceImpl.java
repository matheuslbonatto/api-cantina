package br.senac.cantina.operador.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.cantina.operador.OperadorService;
import br.senac.cantina.operador.dto.CreateOperadorDto;
import br.senac.cantina.shared.models.Operador;
import br.senac.cantina.shared.repositories.OperadorRepository;

@Service
public class OperadorServiceImpl implements OperadorService {

    private OperadorRepository operadorRepository;

    public OperadorServiceImpl(OperadorRepository operadorRepository) {
        this.operadorRepository = operadorRepository;
    }

    @Override
    public Operador save(CreateOperadorDto dto) {
       var operador = new Operador(null, dto.nome(), dto.usuario(), dto.senha());
        return this.operadorRepository.save(operador);
    }

    @Override
    public List<Operador> findAll() {
       return operadorRepository.findAll();
    }

    @Override
    public Operador findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public void update(Operador object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    
}
