package br.com.alura.forumhub.controller;


import br.com.alura.forumhub.domain.DadosAutenticacao;
import br.com.alura.forumhub.domain.DadosTokenJWT;
import br.com.alura.forumhub.domain.model.Usuario;
import br.com.alura.forumhub.service.AutenticacaoService;
import br.com.alura.forumhub.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private TokenService tokenService; // Adicionando o campo tokenService

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.getLogin(), dados.getSenha());
        Authentication authentication = manager.authenticate(authenticationToken);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String tokenGerado = tokenService.gerarToken((Usuario) userDetails);
        return ResponseEntity.ok(new DadosTokenJWT(tokenGerado));
    }

    @PostMapping("criarUsuario")
    public ResponseEntity<String> criarUsuario(@RequestBody @Valid DadosAutenticacao dados) {
        System.out.println(dados.getLogin()+ " " +dados.getSenha());
        var user= autenticacaoService.createUser(dados.getLogin(), dados.getSenha());
        return ResponseEntity.ok(user.getUsername());
    }
}
