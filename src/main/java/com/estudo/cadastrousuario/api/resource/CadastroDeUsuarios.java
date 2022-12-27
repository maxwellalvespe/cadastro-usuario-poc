package com.estudo.cadastrousuario.api.resource;

import com.estudo.cadastrousuario.api.request.UsuarioRequest;
import com.estudo.cadastrousuario.api.response.UsuarioResponse;
import com.estudo.cadastrousuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class CadastroDeUsuarios {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastarUsuario(@Valid @RequestBody UsuarioRequest request) {
        var response = service.cadastrarUsuario(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
