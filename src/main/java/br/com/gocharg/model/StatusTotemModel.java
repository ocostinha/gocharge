package br.com.gocharg.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAT_TOTEM")
@Getter
@Setter
public class StatusTotemModel {

  @Id
  @Column(
      name = "COD_STAT_TOTEM",
      columnDefinition = "INT",
      updatable = false,
      unique = true,
      nullable = false)
  private Integer id;

  @Column(name = "DESCRICAO", columnDefinition = "VARCHAR(250)", nullable = false)
  private String descricao;
}
