package com.estudo.cadastrousuario.repository;

import com.estudo.cadastrousuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<Usuario, Integer> {
}
