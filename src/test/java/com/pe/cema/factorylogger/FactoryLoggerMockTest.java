package com.pe.cema.factorylogger;

import com.pe.cema.factorylogger.enums.LogLevel;
import com.pe.cema.factorylogger.exception.LoggerException;
import com.pe.cema.factorylogger.factory.LoggerHandlerFactory;
import com.pe.cema.factorylogger.logger.Log;
import com.pe.cema.factorylogger.model.repositories.LogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.mockito.Mockito.spy;

@ContextConfiguration
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@SpringBootTest(classes = FactoryLoggerMockTest.class)
public class FactoryLoggerMockTest {

    @MockBean
    private LogRepository logRepository;

    @PrepareForTest({LoggerHandlerFactory.class})
    @Test(expected = LoggerException.class)
    public void cuandoEnvioConfiguracionNulaEntoncesArrojaExcepcion() {
        PowerMockito.mockStatic(LoggerHandlerFactory.class);
        PowerMockito.when(LoggerHandlerFactory.getAvailableHAndlers("excepcionnula", logRepository, LogLevel.INFO))
            .thenReturn(null);
        Log.initializeLogger(this.getClass(), "excepcionnula", logRepository, LogLevel.INFO);

    }

    @PrepareForTest({LoggerHandlerFactory.class})
    @Test(expected = LoggerException.class)
    public void cuandoEnvioConfiguracionVaciaEntoncesArrojaExcepcion() {
        PowerMockito.mockStatic(LoggerHandlerFactory.class);
        PowerMockito
            .when(LoggerHandlerFactory.getAvailableHAndlers("excepcionlistavacia", logRepository, LogLevel.INFO))
            .thenReturn(Collections.emptyList());
        Log.initializeLogger(this.getClass(), "excepcionlistavacia", logRepository, LogLevel.INFO);

    }

    @Test(expected = LoggerException.class)
    public void cuandoIniciaDatabaseHandlerConRepositorioNuloEntoncesArrojaExcepcion() {
        LoggerHandlerFactory.createDataBaseHandler(null, LogLevel.INFO);
    }
}
