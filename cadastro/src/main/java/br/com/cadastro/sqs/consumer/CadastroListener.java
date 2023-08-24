package br.com.cadastro.sqs.consumer;

import br.com.cadastro.sqs.service.CadastroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CadastroListener {

    @Autowired
    CadastroService cadastroService;

    @SqsListener(value = "${cloud.aws.fila.cadastra_cliente}", deletionPolicy = SqsMessageDeletionPolicy.ALWAYS)
    public void consumerCadastro(String message) throws Exception {
        log.info("Message do SQS Queue - cadastro - {}", message);
        cadastroService.realizaCadastro(message);
    }

}