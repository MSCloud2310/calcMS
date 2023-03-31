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
COPY .mvn .
COPY mvnw .
COPY pom.xml .

RUN mvn clean package

# Para solo ejecutar hasta este punto:
# docker build --target builder -t calculadora-build

#-----------------------------------
FROM openjdk:17-alpine AS server
ENV SERVER_PORT=8080
EXPOSE ${SERVER_PORT}
WORKDIR /

VOLUME /tmp
COPY --from=build /app-src/target/app.jar .

COPY start.sh .

ENTRYPOINT ["/start.sh"]

# docker build -t calculadora -f Dockerfile2 .    
# docker run --rm -p 8080:8080 calculadora 