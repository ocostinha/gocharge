package br.com.gocharg.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ConfiguracaoUsuario {
  private UUID id;
  private LocalDateTime dataHoraCadastro;
  private Usuario usuario;
  private Boolean duplaValidacao;
}
