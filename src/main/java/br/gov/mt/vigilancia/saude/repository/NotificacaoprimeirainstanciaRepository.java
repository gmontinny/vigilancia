package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Notificacaoprimeirainstancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoprimeirainstanciaRepository extends JpaRepository<Notificacaoprimeirainstancia, Integer> {
}
