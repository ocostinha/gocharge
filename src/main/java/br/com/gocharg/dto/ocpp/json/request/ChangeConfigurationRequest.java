package br.com.gocharg.dto.ocpp.json.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeConfigurationRequest {
  private String key;
  private String value;
}
