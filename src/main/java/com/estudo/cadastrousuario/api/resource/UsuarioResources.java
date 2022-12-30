package com.estudo.cadastrousuario.api.resource;

import com.estudo.cadastrousuario.api.request.UsuarioRequest;
import com.estudo.cadastrousuario.api.response.UsuarioResponse;
import com.estudo.cadastrousuario.repository.EnqueteRepository;
import com.estudo.cadastrousuario.service.UsuarioService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@Slf4j
public class UsuarioResources {

    private final UsuarioService service;

    //todo fix - adicionar regra no seu devido contexto

    private final EnqueteRepository enqueteRepository;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastarUsuario(@Valid @RequestBody UsuarioRequest request) {
        var response = service.cadastrarUsuario(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
        return new ResponseEntity<>(service.listarUsuarios(), HttpStatus.OK);
    }

}
