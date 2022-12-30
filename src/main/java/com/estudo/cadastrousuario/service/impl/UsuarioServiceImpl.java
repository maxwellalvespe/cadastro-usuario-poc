package com.estudo.cadastrousuario.service.impl;

import com.estudo.cadastrousuario.api.mapper.UsuarioMapper;
import com.estudo.cadastrousuario.api.request.UsuarioRequest;
import com.estudo.cadastrousuario.api.response.UsuarioResponse;
import com.estudo.cadastrousuario.domain.Usuario;
import com.estudo.cadastrousuario.repository.UsuarioRepository;
import com.estudo.cadastrousuario.service.UsuarioService;
import com.estudo.cadastrousuario.service.exception.UsuarioNaoLocalizado;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper mapper;
    private final UsuarioRepository repository;

    @Override
    public UsuarioResponse cadastrarUsuario(UsuarioRequest usuario) {
        Usuario usuarioEntity = repository.save(mapper.toUsuario(usuario));
        return mapper.toResp(usuarioEntity);

    }

    @Override
    public List<UsuarioResponse> listarUsuarios() {
        return repository.findAll().stream()
                .map(mapper::toResp)
                .collect(Collectors.toList());

    }

    @Override
    public Usuario findById(Long id) {
        return repository.findById(id)
                .orElseThrow( () -> new UsuarioNaoLocalizado(String.format("Usuario : %d não localizado na base de dados.",id)));
    }

//    @Override
//    public void updateUsuario(Usuario usuario) {
//        repository.save(usuario);
//    }
}
