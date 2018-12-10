package com.pe.cema.factorylogger;

import ch.qos.logback.core.util.FileUtil;
import com.pe.cema.factorylogger.enums.TipoErrorLogMessage;
import com.pe.cema.factorylogger.exception.LoggerException;
import com.pe.cema.factorylogger.logger.Log;
import com.pe.cema.factorylogger.model.repositories.LogRepository;
import org.h2.store.fs.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Level;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryLoggerApplicationTests {

    @Autowired
    private LogRepository logRepository;

    @Test
    public void testcuandoConfiguracionEsLevelInfoEntoncesLogueaInfoWarningYSevere() {
        String fileName = "prueba.log";
        Log log =
            Log.initializeLogger(FactoryLoggerApplicationTests.class, fileName, logRepository,
                Level.INFO);
        log.info("Hola mundo");
        log.warning("Esto es un warning");
        log.error("Esto es un error", new LoggerException(TipoErrorLogMessage.ERROR_PRUEBA));
        Assert.assertTrue("Archivo Creado", FileUtils.exists(fileName));
    }

}
