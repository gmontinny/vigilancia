package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Resultadosegundainstancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadosegundainstanciaRepository extends JpaRepository<Resultadosegundainstancia, Integer> {
}
