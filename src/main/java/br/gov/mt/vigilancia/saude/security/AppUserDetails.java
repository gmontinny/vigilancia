package br.gov.mt.vigilancia.saude.security;

import br.gov.mt.vigilancia.saude.domain.Permissao;
import br.gov.mt.vigilancia.saude.domain.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppUserDetails implements UserDetails {

    private final Integer id;
    private final String email;
    private final String senha;
    private final boolean enabled;
    private final Set<GrantedAuthority> authorities;

    public AppUserDetails(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        // Regra simples: status != 0 indica habilitado
        this.enabled = usuario.getStatus() == null || usuario.getStatus() != 0;
        this.authorities = buildAuthorities(usuario);
    }

    private Set<GrantedAuthority> buildAuthorities(Usuario usuario) {
        Set<GrantedAuthority> auths = new HashSet<>();
        if (usuario.getPermissoes() != null) {
            for (Permissao p : usuario.getPermissoes()) {
                String tableName = p.getTabela() != null && p.getTabela().getNome() != null
                    ? p.getTabela().getNome().toUpperCase(Locale.ROOT)
                    : "GLOBAL";
                // Para cada flag = 1, cria uma authority do tipo PERM_<TABELA>:<OPERACAO>
                if (isTrue(p.getSelectPermissao())) {
                    auths.add(new SimpleGrantedAuthority("PERM_" + tableName + ":SELECT"));
                }
                if (isTrue(p.getInsertPermissao())) {
                    auths.add(new SimpleGrantedAuthority("PERM_" + tableName + ":INSERT"));
                }
                if (isTrue(p.getUpdatePermissao())) {
                    auths.add(new SimpleGrantedAuthority("PERM_" + tableName + ":UPDATE"));
                }
                if (isTrue(p.getDeletePermissao())) {
                    auths.add(new SimpleGrantedAuthority("PERM_" + tableName + ":DELETE"));
                }
            }
        }
        return auths;
    }

    private boolean isTrue(Integer flag) {
        return flag != null && flag != 0;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
