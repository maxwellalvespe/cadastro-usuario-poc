package com.estudo.cadastrousuario.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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

