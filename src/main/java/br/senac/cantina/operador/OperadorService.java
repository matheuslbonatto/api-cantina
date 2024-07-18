package br.senac.cantina.operador;

import java.util.List;

import br.senac.cantina.operador.dto.CreateOperadorDto;
import br.senac.cantina.shared.models.operador;

public interface OperadorService {

    public operador save(CreateOperadorDto dto);
    
    public static List<operador> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
    public operador findById(Long id);

    public void deleteById(Long id);
}
