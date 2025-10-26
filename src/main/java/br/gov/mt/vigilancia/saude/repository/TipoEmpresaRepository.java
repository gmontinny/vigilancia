package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.TipoEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEmpresaRepository extends JpaRepository<TipoEmpresa, Integer> {
}
