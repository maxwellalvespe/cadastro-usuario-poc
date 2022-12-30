package com.estudo.cadastrousuario.repository;

import com.estudo.cadastrousuario.domain.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VotacaoRepository extends JpaRepository<Votacao,Long> {

    Optional<List<Votacao>> findByEnqueteId(Long idEnquete);
}
