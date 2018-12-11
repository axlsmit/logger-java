package com.pe.cema.factorylogger.handler;

import com.pe.cema.factorylogger.model.entity.LogEntity;
import com.pe.cema.factorylogger.model.repositories.LogRepository;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class DatabaseHandler extends Handler {

    private LogRepository logRepository;

    public DatabaseHandler(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void publish(LogRecord record) {
        LogEntity logEntity = new LogEntity();
        logEntity.setClassName(record.getSourceClassName());
        logEntity.setMethodName(record.getSourceMethodName());
        logEntity.setLevel(record.getLevel().getName());
        logEntity.setMessage(record.getMessage());
        logRepository.save(logEntity);
        flush();
    }

    @Override
    public void flush() {
        logRepository.flush();
    }

    @Override
    public void close() {
        logRepository.flush();
    }
}
