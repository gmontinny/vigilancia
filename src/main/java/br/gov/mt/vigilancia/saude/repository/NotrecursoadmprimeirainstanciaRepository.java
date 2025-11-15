package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Notrecursoadmprimeirainstancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotrecursoadmprimeirainstanciaRepository extends JpaRepository<Notrecursoadmprimeirainstancia, Integer> {
}
