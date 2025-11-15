package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Notificacaosegundainstancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaosegundainstanciaRepository extends JpaRepository<Notificacaosegundainstancia, Integer> {
}
