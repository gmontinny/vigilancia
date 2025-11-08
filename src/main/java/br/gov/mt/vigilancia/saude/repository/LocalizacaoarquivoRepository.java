package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Localizacaoarquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoarquivoRepository extends JpaRepository<Localizacaoarquivo, Integer> {
}
