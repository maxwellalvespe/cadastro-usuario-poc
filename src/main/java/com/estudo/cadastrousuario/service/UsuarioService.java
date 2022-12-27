package com.estudo.cadastrousuario.service;

import com.estudo.cadastrousuario.api.request.UsuarioRequest;
import com.estudo.cadastrousuario.api.response.UsuarioResponse;

import java.util.List;

public interface UsuarioService {
    UsuarioResponse cadastrarUsuario(UsuarioRequest usuario);

    List<UsuarioResponse> listarUsuarios();
}
