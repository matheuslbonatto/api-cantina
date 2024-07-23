package br.senac.cantina.movimentacao;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import br.senac.cantina.shared.models.Movimentacao;

@Repository
public interface MovimentacaoRepository extends ListCrudRepository<Movimentacao, Long> {

}