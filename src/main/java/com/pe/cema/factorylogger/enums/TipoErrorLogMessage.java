package com.pe.cema.factorylogger.enums;

import lombok.Getter;

@Getter
public enum TipoErrorLogMessage {

    ERROR_HANDLERS_CONFIGURATION("001","No se definieron handlers para log"),
    ERROR_CREATE_FILE_HANDLER("002", "No pudo crearse archivo para log"),
    ERROR_CREATE_DATABASE_HANDLER("003", "No pudo crearse persistencia en base de datos para log"),
    ERROR_PRUEBA("004", "esto es un error para probar level severe :)");

    private String code;
    private String message;

    TipoErrorLogMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
