package com.estudo.cadastrousuario.api.mapper;

import com.estudo.cadastrousuario.api.conf.ModelMapperConfig;
import com.estudo.cadastrousuario.api.request.UsuarioRequest;
import com.estudo.cadastrousuario.api.response.UsuarioResponse;
import com.estudo.cadastrousuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {

    private final ModelMapperConfig context;

    public UsuarioResponse toResp(Usuario usuario) {
        return context.mapper().map(usuario, UsuarioResponse.class);
    }

    public Usuario toUsuario(UsuarioRequest req) {
        return context.mapper().map(req, Usuario.class);
    }

}
