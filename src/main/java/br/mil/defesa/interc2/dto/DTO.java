package br.mil.defesa.interc2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record DTO(@JsonProperty("idDto") String idDto, @JsonProperty("origem") String origem,
                  @JsonProperty("destinos") List<String> destinos, @JsonProperty("dataEvento") LocalDate dataEvento) {
}
