package com.pe.cema.factorylogger.logger;

import com.pe.cema.factorylogger.enums.TipoErrorLogMessage;
import com.pe.cema.factorylogger.exception.LoggerException;
import com.pe.cema.factorylogger.factory.LoggerHandlerFactory;
import com.pe.cema.factorylogger.model.repositories.LogRepository;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

@NoArgsConstructor
public class Log {

    private static Logger logger;

    public static Log initializeLogger(Class className, String fileName, LogRepository logRepository, Level level) {
        logger = Logger.getLogger(className.getCanonicalName());
        Log log = new Log();
        List<Handler> handlers = LoggerHandlerFactory.getAvailableHAndlers(fileName, logRepository, level);
        validateHandlersConfiguration(handlers);
        handlers.forEach(logger::addHandler);
        return log;
    }

    private static void validateHandlersConfiguration(List<Handler> handlers) {
        if (handlers == null || handlers.isEmpty()) {
            throw new LoggerException(TipoErrorLogMessage.ERROR_CREATE_DATABASE_HANDLER);
        }
    }

    public void info(String message) {
        logger.log(Level.INFO, message);
    }

    public void error(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }

    public void warning(String message) {
        logger.warning(message);
    }
}
