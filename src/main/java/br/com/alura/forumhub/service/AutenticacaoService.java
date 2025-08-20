package br.com.alura.forumhub.service;

import br.com.alura.forumhub.domain.model.Usuario;
import br.com.alura.forumhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = repository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }



    // cadastra novo usuário
    public Usuario createUser(String username, String rawPassword) {
        if (repository.findByLogin(username) != null) {
            throw new IllegalArgumentException("Login já existe");
        }
        String senhaHash = passwordEncoder.encode(rawPassword);
        Usuario novo = new Usuario(null, username, senhaHash);
        return repository.save(novo);
    }
}
