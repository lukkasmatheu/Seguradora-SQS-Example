package br.com.seguradora.sqs.producer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class ProducerSeguradora {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.fila.cadastra_cliente}")
    private String uriSQSCliente;

    public void enviarMensagemCadastro(String mensagem) {
        queueMessagingTemplate.send(uriSQSCliente, MessageBuilder.withPayload(mensagem).build());
    }

}
