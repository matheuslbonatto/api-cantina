package br.senac.cantina.operador;
import org.springframework.data.repository.ListCrudRepository;
import br.senac.cantina.shared.models.operador;

public interface OperadorRepository  extends ListCrudRepository<operador, Long>{
    
}
