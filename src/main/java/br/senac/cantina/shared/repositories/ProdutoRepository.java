package br.senac.cantina.shared.repositories;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import br.senac.cantina.shared.models.Produto;

@Repository
public interface ProdutoRepository extends ListCrudRepository<Produto, Long>{
}
