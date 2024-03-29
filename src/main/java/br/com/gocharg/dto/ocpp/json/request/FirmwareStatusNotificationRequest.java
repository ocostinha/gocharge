package br.com.gocharg.dto.ocpp.json.request;

import br.com.gocharg.enums.ocpp.OcppFirmwareStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FirmwareStatusNotificationRequest {
  private OcppFirmwareStatusEnum status;
}
