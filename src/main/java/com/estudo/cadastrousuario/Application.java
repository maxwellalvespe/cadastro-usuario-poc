package com.estudo.cadastrousuario;

import com.estudo.cadastrousuario.domain.Enquete;
import com.estudo.cadastrousuario.domain.Usuario;
import com.estudo.cadastrousuario.domain.Votacao;
import com.estudo.cadastrousuario.domain.enums.Voto;
import com.estudo.cadastrousuario.repository.EnqueteRepository;
import com.estudo.cadastrousuario.repository.UsuarioRepository;
import com.estudo.cadastrousuario.repository.VotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class Application  implements CommandLineRunner {

	 private final UsuarioRepository usuarioRepository;
	 private final EnqueteRepository enqueteRepository;
	 private final VotacaoRepository votacaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario max = new Usuario(null,"Maxwell","123",32);
		Usuario bia = new Usuario(null,"bia","123213",27);


		Enquete e1 = new Enquete(null,"CONHECE REACT?");

		Votacao votacao = new Votacao(null,e1,max, Voto.SIM);
		Votacao v2 = new Votacao(null,e1,bia,Voto.SIM);

		usuarioRepository.saveAll(Arrays.asList(max,bia));
		enqueteRepository.save(e1);
		votacaoRepository.saveAll(Arrays.asList(votacao,v2));

	}
}
