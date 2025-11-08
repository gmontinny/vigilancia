package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Itenscategoriaservico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItenscategoriaservicoRepository extends JpaRepository<Itenscategoriaservico, Integer> {
}
