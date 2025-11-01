package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Geracategoriaservico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeracategoriaservicoRepository extends JpaRepository<Geracategoriaservico, Integer> {
}
