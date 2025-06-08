package br.mil.defesa.interc2.controller;

import br.mil.defesa.interc2.dto.DTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@EmbeddedKafka(partitions = 1, topics = { "ORQUESTRADOR" }, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"} )
@RequiredArgsConstructor
public class MensagemControllerTest {

    private final MockMvc mockMvc;
    private final KafkaTemplate<String, DTO> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Test
    void deveEnviarMensagemParaKafka() throws Exception {
        DTO dto = DTO.builder().build();

        mockMvc.perform(post("/entrada")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Mensagem enviada com sucesso!"));
    }

}
