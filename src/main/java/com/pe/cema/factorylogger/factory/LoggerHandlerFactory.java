package com.pe.cema.factorylogger.factory;

import com.pe.cema.factorylogger.enums.TipoErrorLogMessage;
import com.pe.cema.factorylogger.exception.LoggerException;
import com.pe.cema.factorylogger.handler.DatabaseHandler;
import com.pe.cema.factorylogger.model.repositories.LogRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public final class LoggerHandlerFactory {

    private LoggerHandlerFactory() {
    }

    public static Handler createFileHandler(String fileName, Level level) {
        try {
            Handler fileHandler = new FileHandler(fileName, false);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(level);
            return fileHandler;
        } catch (IOException e) {
            throw new LoggerException(TipoErrorLogMessage.ERROR_CREATE_FILE_HANDLER);
        }
    }

    public static Handler createConsoleHandler(Level level) {
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(level);
        return consoleHandler;
    }

    public static Handler createDataBaseHandler(LogRepository logRepository, Level level) {
        if (logRepository == null) {
            throw new LoggerException(TipoErrorLogMessage.ERROR_CREATE_DATABASE_HANDLER);
        }
        DatabaseHandler databaseHandler = new DatabaseHandler(logRepository);
        databaseHandler.setLevel(level);
        return databaseHandler;
    }

    public static List<Handler> getAvailableHAndlers(String fileName, LogRepository logRepository, Level level) {

        List<Handler> handlers = getFileAndConsoleHandlers(fileName, level);
        handlers.add(createDataBaseHandler(logRepository, level));
        return handlers;
    }

    public static List<Handler> getFileAndConsoleHandlers(String fileName, Level level) {
        List<Handler> handlers = new ArrayList<>();
        handlers.add(createConsoleHandler(level));
        handlers.add(createFileHandler(fileName, level));
        return handlers;
    }
}
