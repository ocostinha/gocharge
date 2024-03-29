package br.com.gocharg.processor.ocpp.up;

import br.com.gocharg.command.CommandContext;
import br.com.gocharg.command.CommandProcessor;
import br.com.gocharg.dto.ocpp.json.request.MeterValuesRequest;
import br.com.gocharg.dto.ocpp.json.request.OcppRequest;
import br.com.gocharg.dto.ocpp.json.response.MeterValuesResponse;
import br.com.gocharg.factory.OcppResponseFactory;
import br.com.gocharg.repository.TotemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MeterValueProcessor implements CommandProcessor<String> {

  @Autowired private TotemRepository repository;
  @Autowired private OcppResponseFactory factory;

  @Override
  public String process(CommandContext context) {
    OcppRequest ocppRequest = context.getProperty("ocppRequest", OcppRequest.class);

    MeterValuesRequest request = (MeterValuesRequest) ocppRequest.getPayload();
    String retorno = new String();
    MeterValuesResponse response = new MeterValuesResponse();

    try {
      retorno =
          factory.retorno(
              ocppRequest.getUniqueId(), "{}");
    } catch (Exception e) {
      System.out.println("Erro na conversão para JSON");
    }

    return retorno;
  }
}
