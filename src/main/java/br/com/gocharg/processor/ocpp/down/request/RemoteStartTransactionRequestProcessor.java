package br.com.gocharg.processor.ocpp.down.request;

import br.com.gocharg.command.CommandContext;
import br.com.gocharg.command.CommandProcessor;
import br.com.gocharg.dto.ocpp.json.request.OcppRequest;
import br.com.gocharg.dto.ocpp.json.request.RemoteStartTransactionRequest;
import br.com.gocharg.enums.ocpp.OcppFunctionsEnum;
import br.com.gocharg.enums.ocpp.OcppMessageTypeEnum;
import br.com.gocharg.factory.OcppResponseFactory;
import br.com.gocharg.infrastructure.StompClient;
import br.com.gocharg.processor.ocpp.OcppLogProcessor;
import br.com.gocharg.repository.TransacaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoteStartTransactionRequestProcessor implements CommandProcessor {

  @Autowired private StompClient stompClient;
  @Autowired private OcppResponseFactory factory;
  @Autowired private TransacaoRepository transacaoRepository;
  @Autowired private OcppLogProcessor ocppLogProcessor;

  @Override
  public Object process(CommandContext context) {
    try {
      String apelidoTotem = context.getProperty("apelidoTotem", String.class);
      String usuario = context.getProperty("usuario", String.class);
      Integer uniqueId = transacaoRepository.getNextIdByApelidoTotem(apelidoTotem);
      RemoteStartTransactionRequest request = new RemoteStartTransactionRequest();

      request.setConnectorId(0);
      request.setIdTag(usuario);

      String messageEv =
          factory.requisicao(
              uniqueId.toString(),
              OcppFunctionsEnum.REMOTE_START_TRANSACTION.getFunction(),
              new ObjectMapper().writeValueAsString(request));

      stompClient.open(apelidoTotem, messageEv);

      OcppRequest ocppRequest = new OcppRequest();

      ocppRequest.setApelidoTotem(apelidoTotem);
      ocppRequest.setOperation(OcppMessageTypeEnum.CALL);
      ocppRequest.setAction(OcppFunctionsEnum.REMOTE_START_TRANSACTION);
      ocppRequest.setUniqueId(uniqueId);
      ocppRequest.setPayload(request);

      context.put("ocppRequest", ocppRequest);

      ocppLogProcessor.process(context);
    } catch (Exception e) {
      System.out.println("Erro na conversão para JSON");
    }

    return null;
  }
}
