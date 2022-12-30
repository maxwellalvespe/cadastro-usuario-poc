package com.estudo.cadastrousuario.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome",nullable = false)
    private String nome;
    @Column(name = "cpf" , nullable = false, unique = true)
    private String cpf;
    private int idade;

//    @JsonIgnore
//    @ManyToMany
//    private List<Enquete> enquete = new ArrayList<>();

}
