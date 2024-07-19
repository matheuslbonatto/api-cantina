
package br.senac.cantina.operador;

import java.util.List;

import br.senac.cantina.operador.dto.CreateOperadorDto;
import br.senac.cantina.shared.models.Operador;


public interface OperadorService {

    public Operador save(CreateOperadorDto dto);
    
    public List<Operador> findAll();

    public void update(Operador object);
    
    public Operador findById(Long id);

    public void deleteById(Long id);
}
