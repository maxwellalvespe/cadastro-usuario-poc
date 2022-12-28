package com.estudo.cadastrousuario.service;

import com.estudo.cadastrousuario.api.request.UsuarioRequest;
import com.estudo.cadastrousuario.api.response.UsuarioResponse;
import com.estudo.cadastrousuario.domain.Usuario;

import java.util.List;

public interface UsuarioService {
    UsuarioResponse cadastrarUsuario(UsuarioRequest usuario);

    List<UsuarioResponse> listarUsuarios();

    Usuario findById(Long id);

    void updateUsuario(Usuario usuario);
}
