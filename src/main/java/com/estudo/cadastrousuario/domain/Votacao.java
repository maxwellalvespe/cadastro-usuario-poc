package com.estudo.cadastrousuario.domain;


import com.estudo.cadastrousuario.domain.enums.Voto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Votacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "enquete_id")
    private Enquete enquete;//Long inEnquete;

    @OneToOne
    @JoinColumn(name ="usuario_id")
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    private Voto voto;
}
