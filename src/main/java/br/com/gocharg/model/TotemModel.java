package br.com.gocharg.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "CAD_TOTEM")
@Getter
@Setter
public class TotemModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(
      name = "COD_TOTEM",
      columnDefinition = "VARCHAR(36)",
      updatable = false,
      unique = true,
      nullable = false)
  private UUID id;

  @Column(name = "DT_HR_CAD", columnDefinition = "DATETIME", updatable = false, nullable = false)
  private LocalDateTime dataHoraCadastro;

  @ManyToOne
  @JoinColumn(
      name = "COD_EST",
      referencedColumnName = "COD_EST",
      columnDefinition = "VARCHAR(2)",
      nullable = false)
  private EstadoModel estado;

  @ManyToOne
  @JoinColumn(
      name = "COD_CID",
      referencedColumnName = "COD_CID",
      columnDefinition = "INTEGER",
      nullable = false)
  private CidadeModel cidade;

  @ManyToOne
  @JoinColumn(
      name = "COD_ZONA",
      referencedColumnName = "COD_ZONA",
      columnDefinition = "VARCHAR(36)",
      nullable = false)
  private ZonaModel zona;

  @ManyToOne
  @JoinColumn(
      name = "COD_SUB_ZONA",
      referencedColumnName = "COD_SUB_ZONA",
      columnDefinition = "VARCHAR(36)",
      nullable = false)
  private SubZonaModel subZona;

  @ManyToOne
  @JoinColumn(
      name = "COD_VALOR",
      referencedColumnName = "COD_VALOR",
      columnDefinition = "VARCHAR(36)",
      nullable = false)
  private ValorModel valor;

  @ManyToOne
  @JoinColumn(
      name = "COD_FAB",
      referencedColumnName = "COD_FAB",
      columnDefinition = "VARCHAR(36)",
      nullable = false)
  private FabricanteModel fabricante;

  @ManyToOne
  @JoinColumn(
      name = "COD_STAT_TOTEM",
      referencedColumnName = "COD_STAT_TOTEM",
      columnDefinition = "INT",
      nullable = false)
  private StatusTotemModel status;

  @Column(name = "APELIDO", columnDefinition = "VARCHAR(250)", nullable = false)
  private String apelido;

  @Column(name = "MAPS", columnDefinition = "TINYINT(1)", nullable = false)
  private Boolean maps;

  @Column(name = "PROP_GOCH", columnDefinition = "TINYINT(1)", nullable = false)
  private Boolean propriedadeGoCharg;

  @OneToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(name = "COD_USU", referencedColumnName = "COD_USU", columnDefinition = "VARCHAR(36)")
  private UsuarioModel proprietario;

  @Column(name = "QRCODE", columnDefinition = "VARCHAR(250)", nullable = false)
  private String qrCode;

  @ManyToOne(cascade = CascadeType.REFRESH)
  @JoinColumn(
      name = "COD_CATEG",
      referencedColumnName = "COD_CATEG",
      columnDefinition = "VARCHAR(1)")
  private CategoriaModel categoria;

  @Column(name = "OBS_1", columnDefinition = "VARCHAR(65535)")
  private String observacao1;

  @Column(name = "OBS_2", columnDefinition = "VARCHAR(65535)")
  private String observacao2;
}
