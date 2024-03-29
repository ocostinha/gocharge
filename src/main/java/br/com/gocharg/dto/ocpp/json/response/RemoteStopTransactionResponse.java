package br.com.gocharg.dto.ocpp.json.response;

import br.com.gocharg.enums.ocpp.OcppResponseStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteStopTransactionResponse {
  private OcppResponseStatusEnum status;
}
