package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Despachoimprocedencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespachoimprocedenciaRepository extends JpaRepository<Despachoimprocedencia, Integer> {
}
