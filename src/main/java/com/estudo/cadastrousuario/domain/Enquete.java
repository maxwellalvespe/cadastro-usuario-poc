package com.estudo.cadastrousuario.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Enquete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;

//    @OneToOne
//    @JsonIgnore
//    private Votacao voto;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Usuario> usuarios = new ArrayList<>();

}

