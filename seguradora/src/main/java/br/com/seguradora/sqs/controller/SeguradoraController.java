package br.com.seguradora.sqs.controller;

import br.com.seguradora.sqs.producer.ProducerSeguradora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seguradora")
public class SeguradoraController {

    @Autowired
    private ProducerSeguradora producerSeguradora;

    @PostMapping("/cliente")
    public ResponseEntity<String> cadastraSegurado(@RequestBody String mensagem){
        producerSeguradora.enviarMensagemCadastro(mensagem);
        return ResponseEntity.ok("Solicitação de cadastro enviada com sucesso.");
    }
}
