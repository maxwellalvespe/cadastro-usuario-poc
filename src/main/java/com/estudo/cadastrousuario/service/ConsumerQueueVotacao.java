package com.estudo.cadastrousuario.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerQueueVotacao {

    private final String QUEUE_NAME = "votos.queue";

    record DtoRequest(Long usuario,
                      Long enquete,
                      String voto) {
    }


    @RabbitListener(queues = QUEUE_NAME)
    public void consumer(Message message, DtoRequest request) {
        //TODO fix-atualizar DTO-do producer para que o recurso de votação para que o ponto de entrada dos votos seja realizado por ele e não pelo endpoint desse ms
        log.info("DTO OBTIDO {}", request);

    }

}
