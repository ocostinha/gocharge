package br.com.gocharg.dto.ocpp.json.request;

import br.com.gocharg.enums.ocpp.OcppFunctionsEnum;
import br.com.gocharg.enums.ocpp.OcppMessageTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OcppRequest<T> {
  private OcppMessageTypeEnum operation;
  private Integer uniqueId;
  private OcppFunctionsEnum action;
  private T payload;
  private String apelidoTotem;
}
