package br.com.gocharg.enums.ocpp;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.apache.commons.lang.StringUtils;

import java.util.stream.Stream;

@Getter
public enum OcppErrorCodeEnum {
  CONNECTOR_LOCK_FAILURE("ConnectorLockFailure"),
  EV_COMMUNICATION_ERROR("EVCommunicationError"),
  GROUND_FAILURE("GroundFailure"),
  HIGH_TEMPERATURE("HighTemperature"),
  INTERNAL_ERROR("InternalError"),
  LOCAL_LIST_CONFLICT("LocalListConflict"),
  NO_ERROR("NoError"),
  OTHER_ERROR("OtherError"),
  OVER_CURRENT_FAILURE("OverCurrentFailure"),
  POWER_METER_FAILURE("PowerMeterFailure"),
  POWER_SWITCH_FAILURE("PowerSwitchFailure"),
  READER_FAILURE("ReaderFailure"),
  RESET_FAILURE("ResetFailure"),
  UNDER_VOLTAGE("UnderVoltage"),
  OVER_VOLTAGE("OverVoltage"),
  WEAK_SIGNAL("WeakSignal");

  private String error;

  OcppErrorCodeEnum(String error) {
    this.error = error;
  }

  public static OcppErrorCodeEnum get(String status) {
    return Stream.of(OcppErrorCodeEnum.values())
        .filter(value -> value.getError().equals(status))
        .findFirst()
        .orElse(null);
  }

  @JsonCreator
  public static OcppErrorCodeEnum forValue(String value) {
    return OcppErrorCodeEnum.get(value);
  }

  public static boolean contains(String codigo) {
    return Stream.of(OcppErrorCodeEnum.values()).anyMatch(status -> status.equals(codigo));
  }
}
