package br.com.gocharg.dto.ocpp.json.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataTransferRequest {
  private String vendorId;
  private String messageId;
  private String data;
}
