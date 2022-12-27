package com.estudo.cadastrousuario.api.resource;

import com.estudo.cadastrousuario.api.request.UsuarioRequest;
import com.estudo.cadastrousuario.api.response.UsuarioResponse;
import com.estudo.cadastrousuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios(){
        return new ResponseEntity<>(service.listarUsuarios(),HttpStatus.OK);
    }
}
