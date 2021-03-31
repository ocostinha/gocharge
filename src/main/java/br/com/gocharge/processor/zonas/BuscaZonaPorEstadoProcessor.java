package br.com.gocharge.processor.zonas;

import br.com.gocharge.command.CommandContext;
import br.com.gocharge.command.CommandProcessor;
import br.com.gocharge.domain.Zona;
import br.com.gocharge.repository.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscaZonaPorEstadoProcessor implements CommandProcessor<List<Zona>> {

  @Autowired private ZonaRepository zonaRepository;

  @Override
  public List<Zona> process(CommandContext context) {
    String idEstado = context.getProperty("idEstado", String.class);

    return zonaRepository.getByEstado(idEstado);
  }
}