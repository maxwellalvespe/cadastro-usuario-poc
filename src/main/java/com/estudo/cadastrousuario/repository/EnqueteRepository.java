package com.estudo.cadastrousuario.repository;

import com.estudo.cadastrousuario.domain.Enquete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnqueteRepository extends JpaRepository<Enquete, Long> {
}
