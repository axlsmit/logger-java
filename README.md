# logger-java {<img src="https://travis-ci.org/axlsmit/logger-java.svg?branch=master" alt="Build Status" />}[https://travis-ci.org/axlsmit/logger-java]
Repositorio con prueba de concepto sobre el api logging de java 8.
# ejecución
Para probar este proyecto debes ejecutar lo siguiente.
Para mac / linux
  sh gradlew bootRun
Para windows
  gradlew.bat bootRun
# ejecucion de tests
 mac/ linux: sh gradlew test
 windos gradlew.bat test

# Análisis de código estático
sh gradlew sonarqube \
  -Dsonar.projectKey=axlsmit_logger-java \
  -Dsonar.organization=axlsmit-github \
  -Dsonar.host.url=https://sonarcloud.io \
  -Dsonar.login=57fd8431c75c819e4ab0506481a7222d311eec17

# Respuesta a pregunta 1.
https://docs.google.com/document/d/1pMbZvYbf-JaIoJEx1aq4QgCfkjZWQwCwRsnAGr_88zY/edit?usp=sharing
  
