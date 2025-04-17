# Usar la imagen base de OpenJDK
FROM openjdk:21-jdk-slim

# Copiar el JAR generado en el contenedor
COPY target/spicardo-0.0.1-SNAPSHOT.jar /app/spicardo.jar

# Establecer el directorio de trabajo
WORKDIR /app

# Exponer el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "spicardo.jar"]
