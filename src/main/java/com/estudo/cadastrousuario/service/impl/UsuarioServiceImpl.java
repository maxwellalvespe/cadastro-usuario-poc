package com.estudo.cadastrousuario.service.impl;

import com.estudo.cadastrousuario.api.mapper.UsuarioMapper;
import com.estudo.cadastrousuario.api.request.UsuarioRequest;
import com.estudo.cadastrousuario.api.response.UsuarioResponse;
import com.estudo.cadastrousuario.domain.Usuario;
import com.estudo.cadastrousuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper mapper;

    @Override
    public UsuarioResponse cadastrarUsuario(UsuarioRequest usuario) {


        Usuario usuarioEntity = mapper.toUsuario(usuario);

        return mapper.toResp(usuarioEntity);


    }
}
