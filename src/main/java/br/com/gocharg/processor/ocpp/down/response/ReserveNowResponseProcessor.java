package br.com.gocharg.processor.ocpp.down.response;

import br.com.gocharg.command.CommandContext;
import br.com.gocharg.command.CommandProcessor;
import br.com.gocharg.domain.Totem;
import br.com.gocharg.dto.ocpp.json.request.OcppRequest;
import br.com.gocharg.dto.ocpp.json.response.ReserveNowResponse;
import br.com.gocharg.enums.StatusTotemEnum;
import br.com.gocharg.factory.OcppResponseFactory;
import br.com.gocharg.repository.TotemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReserveNowResponseProcessor implements CommandProcessor {

  @Autowired private TotemRepository repository;
  @Autowired private OcppResponseFactory factory;

  @Override
  public Object process(CommandContext context) {
    OcppRequest ocppRequest = context.getProperty("ocppRequest", OcppRequest.class);

    ReserveNowResponse response = (ReserveNowResponse) ocppRequest.getPayload();

    // TODO Inserir na tabela de transação

    Totem totem = repository.getByApelido("EV1");
    totem.setStatus(StatusTotemEnum.RESERVADO);

    repository.update(totem);

    return null;
  }
}
