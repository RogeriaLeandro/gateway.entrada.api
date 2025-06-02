package br.mil.defesa.interc2.kafka.producer;

import br.mil.defesa.interc2.dto.DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${topico.orquestrador}")
    private String topicoOrquestrador;

    private final KafkaTemplate<String, DTO> kafkaTemplate;

    public void enviarMensagem(DTO dto) {
        dto.destinos().forEach(destino -> {
            if (topicoOrquestrador == null) {
                throw new IllegalArgumentException("Destino inválido: " + destino);
            }
            kafkaTemplate.send(topicoOrquestrador, dto);
        });
    }

}
