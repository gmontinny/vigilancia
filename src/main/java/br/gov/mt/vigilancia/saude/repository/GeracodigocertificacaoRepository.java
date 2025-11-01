package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Geracodigocertificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeracodigocertificacaoRepository extends JpaRepository<Geracodigocertificacao, Integer> {
}
