package com.estudo.cadastrousuario.api.resource;

import com.estudo.cadastrousuario.domain.Enquete;
import com.estudo.cadastrousuario.service.EnqueteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enquetes")
@RequiredArgsConstructor
public class EnqueteResources {


    private final EnqueteService service;

    @PostMapping()
    public ResponseEntity<?> cadastrarEnquete(@RequestBody Enquete enquete) {
        return new ResponseEntity<>(service.salvar(enquete), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Enquete>> obterEnquetes() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }
}
