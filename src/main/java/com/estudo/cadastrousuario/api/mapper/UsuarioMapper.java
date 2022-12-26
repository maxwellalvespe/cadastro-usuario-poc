package com.estudo.cadastrousuario.api.mapper;

import com.estudo.cadastrousuario.api.conf.ModelMapperConfig;
import com.estudo.cadastrousuario.api.request.UsuarioRequest;
import com.estudo.cadastrousuario.api.response.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import padroes.padroesapi.domain.Usuario;

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
