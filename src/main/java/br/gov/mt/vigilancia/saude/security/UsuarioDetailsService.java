package br.gov.mt.vigilancia.saude.security;

import br.gov.mt.vigilancia.saude.domain.Usuario;
import br.gov.mt.vigilancia.saude.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // username = email
        Usuario usuario = usuarioRepository.findByEmailWithPermissoes(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        return new AppUserDetails(usuario);
    }

    public UserDetails loadUserByCpf(String cpf) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCpfWithPermissoes(cpf)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado para CPF: " + cpf));
        return new AppUserDetails(usuario);
    }
}
