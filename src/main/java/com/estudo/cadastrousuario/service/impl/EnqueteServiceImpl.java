package com.estudo.cadastrousuario.service.impl;

import com.estudo.cadastrousuario.domain.Enquete;
import com.estudo.cadastrousuario.repository.EnqueteRepository;
import com.estudo.cadastrousuario.service.EnqueteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnqueteServiceImpl implements EnqueteService {

    private final EnqueteRepository repository;
    @Override
    public List<Enquete> listar() {
        return repository.findAll();
    }

    @Override
    public Enquete salvar(Enquete enquete) {
        return repository.save(enquete);
    }
}
