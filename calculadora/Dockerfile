FROM adoptopenjdk/openjdk11:alpine-jre
ENV SERVER_PORT=8080
EXPOSE ${SERVER_PORT}/tcp

VOLUME ["/tmp"]

ADD target/app.jar .
ADD start.sh .

ENTRYPOINT ["/start.sh" ]