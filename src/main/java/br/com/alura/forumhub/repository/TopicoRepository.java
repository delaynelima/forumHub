package br.com.alura.forumhub.repository;

import br.com.alura.forumhub.domain.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Optional<Topico> findByTituloAndNomeAutor(String titulo, String nomeAutor);

}