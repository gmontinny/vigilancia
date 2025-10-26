package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.ResponsavelTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelTecnicoRepository extends JpaRepository<ResponsavelTecnico, Integer> {
}
