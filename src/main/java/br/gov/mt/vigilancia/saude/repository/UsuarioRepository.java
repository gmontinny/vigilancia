package br.gov.mt.vigilancia.saude.repository;

import br.gov.mt.vigilancia.saude.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u left join fetch u.permissoes p left join fetch p.tabela where lower(u.email) = lower(:email)")
    Optional<Usuario> findByEmailWithPermissoes(@Param("email") String email);

    @Query("select u from Usuario u left join fetch u.permissoes p left join fetch p.tabela where u.cpf = :cpf")
    Optional<Usuario> findByCpfWithPermissoes(@Param("cpf") String cpf);
}
