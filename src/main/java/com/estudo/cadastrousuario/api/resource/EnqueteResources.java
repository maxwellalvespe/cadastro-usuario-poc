package com.estudo.cadastrousuario.api.resource;

import com.estudo.cadastrousuario.domain.Enquete;
import com.estudo.cadastrousuario.repository.EnqueteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enquetes")
@RequiredArgsConstructor
public class EnqueteResources {


    private final EnqueteRepository enqueteRepository;

    @PostMapping()
    public ResponseEntity<?> vincularenqueteAoUsuario(@RequestBody Enquete enquete) {
        var response = enqueteRepository.save(enquete);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Enquete>> obterEnquetes(){
        return  new ResponseEntity<>(enqueteRepository.findAll(),HttpStatus.OK);
    }
}
