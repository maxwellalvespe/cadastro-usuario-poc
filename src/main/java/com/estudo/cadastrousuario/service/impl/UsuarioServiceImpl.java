package com.estudo.cadastrousuario.service.impl;

import com.estudo.cadastrousuario.api.mapper.UsuarioMapper;
import com.estudo.cadastrousuario.api.request.UsuarioRequest;
import com.estudo.cadastrousuario.api.response.UsuarioResponse;
import com.estudo.cadastrousuario.domain.Usuario;
import com.estudo.cadastrousuario.repository.CrudRepository;
import com.estudo.cadastrousuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper mapper;
    private final CrudRepository repository;

    @Override
    public UsuarioResponse cadastrarUsuario(UsuarioRequest usuario) {
        Usuario usuarioEntity = repository.save(mapper.toUsuario(usuario));
        return mapper.toResp(usuarioEntity);

    }

    @Override
    public List<UsuarioResponse> listarUsuarios() {

        return repository.findAll().stream()
                .map(n -> mapper.toResp(n))
                .collect(Collectors.toList());

    }
}
