package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Notificacaorecursoadministrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaorecursoadministrativoRepository extends JpaRepository<Notificacaorecursoadministrativo, Integer> {
}
