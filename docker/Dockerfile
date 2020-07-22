FROM openjdk:8

RUN mkdir -p /var/service/log && \
    mkdir -p /var/service/config && \
    chown -R nobody /var/service

WORKDIR /var/service/

USER nobody

ARG ARTIFACT

ENV KEYSTORE_PATH=/var/service/keystore
ENV KEYSTORE_PASSWORD=12345678

COPY $ARTIFACT /var/service/service.jar
COPY config.yml /var/service/config.yml
COPY keystore ${KEYSTORE_PATH}

CMD java -jar /var/service/service.jar server config.yml
