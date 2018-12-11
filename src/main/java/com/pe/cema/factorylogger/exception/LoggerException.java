package com.pe.cema.factorylogger.exception;

import com.pe.cema.factorylogger.enums.TipoErrorLogMessage;

public class LoggerException extends RuntimeException {

    private final TipoErrorLogMessage tipoErrorLogMessage;

    public LoggerException(TipoErrorLogMessage tipoErrorLogMessage) {
        this.tipoErrorLogMessage = tipoErrorLogMessage;
    }

    @Override
    public String getMessage() {
        return String.format("%s: %s", this.tipoErrorLogMessage.getCode(), this.tipoErrorLogMessage.getMessage());
    }
}
