package br.com.gocharg.dto.ocpp.json.request;

import br.com.gocharg.enums.ocpp.OcppDiagnosticsStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiagnosticsStatusNotificationRequest {
  private OcppDiagnosticsStatusEnum status;
}
