package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Alvara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlvaraRepository extends JpaRepository<Alvara, Integer> {
}
