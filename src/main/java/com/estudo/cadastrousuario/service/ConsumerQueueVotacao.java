package com.estudo.cadastrousuario.service;

import com.estudo.cadastrousuario.api.request.VotacaoRequest;
import com.estudo.cadastrousuario.domain.enums.Voto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerQueueVotacao {

    private final String QUEUE_NAME = "votos.queue";
    private final VotacaoService votacaoService;


    @RabbitListener(queues = QUEUE_NAME)
    public void consumer(Message message, VotacaoRequest request) {
        //TODO fix-atualizar DTO-do producer para que o recurso de votação para que o ponto de entrada dos votos seja realizado por ele e não pelo endpoint desse ms
        log.info("DTO OBTIDO {}", request);
        log.info("menssagem obtida {}", message);
        try {
            var retorno = votacaoService.salvar(request.getUsuario(), request.getEnquete(), Voto.valueOf(request.getVoto()));
            log.info("Voto salvo na base de dados {}", retorno.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
