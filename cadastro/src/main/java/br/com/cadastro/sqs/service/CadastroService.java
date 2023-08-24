package br.com.cadastro.sqs.service;

import br.com.cadastro.sqs.model.Cliente;
import br.com.cadastro.sqs.repository.ClienteRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CadastroService {
    @Autowired
    ClienteRepository clienteRepository;
    public void realizaCadastro(String message) {
        log.info("Cadastro do cliente esta sendo realizado {}", message);
        Gson gson = new GsonBuilder().create();
        Cliente cliente = gson.fromJson(message, Cliente.class);
        clienteRepository.save(cliente);
        log.info("[Cadastro Cliente]- Cliente com id {} Cadastrado com sucesso.", cliente.getId());
    }

}
