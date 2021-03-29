package br.com.gocharge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CidadeDTO {

  @JsonProperty("id")
  private String id;

  @JsonProperty("estado")
  private String estado;

  @JsonProperty("cidade")
  private String descricao;
}