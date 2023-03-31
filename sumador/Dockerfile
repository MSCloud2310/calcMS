#
# Etapa de compilacion y empaquetamiento
#
# Para que funcione, hay que agregar al pom.xml
# <properties>
#   ...
# 	<spring-boot.repackage.skip>true</spring-boot.repackage.skip>
# </properties>
#
# También, agregar en pom.xml:
# <build>
#   <finalName>app</finalName>
#   ...
# </build>
FROM maven:3 AS build
WORKDIR /app-src
COPY src src
COPY pom.xml .
RUN mvn clean package

# Para solo ejecutar hasta este punto:
# docker build --target builder -t calculadora-build

#-----------------------------------

FROM openjdk:17-alpine AS server
ENV SERVER_PORT=8888
EXPOSE ${SERVER_PORT}/tcp

VOLUME ["/tmp"]

COPY --from=build /app-src/target/app.jar .
COPY start.sh .


ENTRYPOINT ["/start.sh" ]