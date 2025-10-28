package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Bloqueioitenssolicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqueioitenssolicitacaoRepository extends JpaRepository<Bloqueioitenssolicitacao, Integer> {
}
