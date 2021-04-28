package br.com.gocharg.domain;

import br.com.gocharg.enums.StatusTotemEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Totem {
  private UUID id;
  private LocalDateTime dataHoraCadastro;
  private Estado estado;
  private Cidade cidade;
  private Zona zona;
  private SubZona subZona;
  private Valor valor;
  private Fabricante fabricante;
  private StatusTotemEnum status;
  private String apelido;
}