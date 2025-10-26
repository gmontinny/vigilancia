package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.ProdutoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoCategoriaRepository extends JpaRepository<ProdutoCategoria, Integer> {
}
