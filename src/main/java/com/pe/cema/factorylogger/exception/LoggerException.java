package com.pe.cema.factorylogger.exception;

import com.pe.cema.factorylogger.enums.TipoErrorLogMessage;

public class LoggerException extends RuntimeException {

    TipoErrorLogMessage tipoErrorLogMessage;

    public LoggerException(TipoErrorLogMessage tipoErrorLogMessage) {
        this.tipoErrorLogMessage = tipoErrorLogMessage;
    }

    @Override
    public String getMessage() {
        return this.tipoErrorLogMessage.getMessage();
    }
}
