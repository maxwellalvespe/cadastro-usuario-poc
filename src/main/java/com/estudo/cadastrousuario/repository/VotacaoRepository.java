package com.estudo.cadastrousuario.repository;

import com.estudo.cadastrousuario.domain.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotacaoRepository extends JpaRepository<Votacao,Long> {
}
