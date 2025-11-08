package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Itensrelatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensrelatorioRepository extends JpaRepository<Itensrelatorio, Integer> {
}
