package br.mil.defesa.interc2.controller;

import br.mil.defesa.interc2.dto.DTO;
import br.mil.defesa.interc2.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/entrada")
@RequiredArgsConstructor
public class MensagemController {

    private final KafkaProducer kafkaProducer;

    @PostMapping()
    public ResponseEntity<String> enviaMensagem(@RequestBody DTO dto) {
        kafkaProducer.enviarMensagem(dto);
        return ResponseEntity.ok("Mensagem enviada com sucesso!");
    }
}
