package br.com.gocharg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoDTO {

  @JsonProperty("id")
  private String id;

  @JsonProperty("estado")
  private String descricao;
}
