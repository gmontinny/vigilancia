package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Integer> {
}
