package com.estudo.cadastrousuario.repository;

import com.estudo.cadastrousuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
