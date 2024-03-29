package br.com.gocharg.repository;

import br.com.gocharg.domain.Transacao;
import br.com.gocharg.mappers.TransacaoMapper;
import br.com.gocharg.model.TransacaoModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
@Transactional
public class TransacaoRepository {

  @PersistenceContext EntityManager entityManager;

  public List<Transacao> getAll() {
    List<TransacaoModel> transacoes =
        entityManager.createQuery("SELECT z FROM TransacaoModel z").getResultList();

    if (transacoes.size() > 0) {
      return TransacaoMapper.INSTANCE.toDomain(transacoes);
    } else {
      return new ArrayList<>();
    }
  }

  public Transacao getById(UUID id) {
    TransacaoModel transacao = entityManager.find(TransacaoModel.class, id);

    if (Objects.nonNull(transacao)) {
      return TransacaoMapper.INSTANCE.toDomain(transacao);
    } else {
      return null;
    }
  }

  public List<Transacao> getByTotem(UUID idTotem) {
    List<TransacaoModel> transacoes =
        entityManager
            .createQuery("SELECT t FROM TransacaoModel t WHERE t.totem.id = :idTotem")
            .setParameter("idTotem", idTotem)
            .getResultList();

    if (transacoes.size() > 0) {
      return TransacaoMapper.INSTANCE.toDomain(transacoes);
    } else {
      return new ArrayList<>();
    }
  }

  public Transacao getByApelidoAndUniqueId(String apelido, String uniqueId) {
    return TransacaoMapper.INSTANCE.toDomain(
        (TransacaoModel)
            entityManager
                .createQuery(
                    "SELECT t FROM TransacaoModel t "
                        + "WHERE t.totem.apelido = :apelido "
                        + "AND t.uniqueId =: uniqueId " +
                            "ORDER BY t.dataHoraCadastro DESC")
                .setParameter("apelido", apelido)
                .setParameter("uniqueId", Integer.valueOf(uniqueId))
                .getResultList().stream().findFirst().get());
  }

  public Integer getNextIdByApelidoTotem(String apelidoTotem) {
    List<TransacaoModel> transacoes =
        entityManager
            .createQuery("SELECT t FROM TransacaoModel t WHERE t.totem.apelido = :apelidoTotem")
            .setParameter("apelidoTotem", apelidoTotem)
            .getResultList();

    return transacoes.size() > 0
        ? transacoes.stream().mapToInt(t -> t.getUniqueId()).max().getAsInt() + 1
        : 1;
  }

  public Integer getLastIdByApelidoTotem(String apelidoTotem) {
    List<TransacaoModel> transacoes =
        entityManager
            .createQuery("SELECT t FROM TransacaoModel t WHERE t.totem.apelido = :apelidoTotem")
            .setParameter("apelidoTotem", apelidoTotem)
            .getResultList();

    return transacoes.size() > 0
        ? transacoes.stream().mapToInt(t -> t.getUniqueId()).max().getAsInt()
        : 1;
  }

  public Transacao create(Transacao transacao) {
    TransacaoModel TransacaoModel = TransacaoMapper.INSTANCE.toModel(transacao);

    entityManager.persist(TransacaoModel);

    return TransacaoMapper.INSTANCE.toDomain(TransacaoModel);
  }

  public void delete(UUID id) {
    TransacaoModel zona = entityManager.find(TransacaoModel.class, id);

    if (Objects.nonNull(zona)) {
      entityManager.remove(zona);
    }
  }

  public void deleteByTotem(UUID idTotem) {
    List<TransacaoModel> transacoes =
        entityManager
            .createQuery("SELECT t FROM TransacaoModel t WHERE t.totem.id = :idTotem")
            .setParameter("idTotem", idTotem)
            .getResultList();

    if (transacoes.size() > 0) {
      entityManager.remove(transacoes);
    }
  }

  public void deleteByApelidoTotem(String apelidoTotem) {
    List<TransacaoModel> transacoes =
        entityManager
            .createQuery("SELECT t FROM TransacaoModel t WHERE t.totem.apelido = :apelidoTotem")
            .setParameter("apelidoTotem", apelidoTotem)
            .getResultList();

    if (transacoes.size() > 0) {
      transacoes.forEach(transacao -> entityManager.remove(transacao));
    }
  }
}
