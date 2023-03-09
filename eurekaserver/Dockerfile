FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8761

VOLUME ["/tmp"]

ADD target/app.jar .

ENTRYPOINT [ "java", "-jar", "app.jar" ]