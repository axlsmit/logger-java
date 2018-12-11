package com.pe.cema.factorylogger.enums;

import lombok.Getter;

import java.util.logging.Level;

@Getter
public enum LogLevel {

    INFO(Level.INFO),
    WARNING(Level.WARNING),
    ERROR(Level.SEVERE);

    LogLevel(Level level) {
        this.level = level;
    }

    private Level level;

}
