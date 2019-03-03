FROM maven:3.5.0-jdk-8-alpine as builder
WORKDIR /opt/
ADD demo /opt/
RUN mvn install spring-boot:repackage

FROM openjdk:8-jdk-alpine
ADD entrypoint.sh /app/entrypoint.sh
RUN apk add --update bash && rm -rf /var/cache/apk/* && \
    addgroup -g 82 -S webapp && \
    adduser -u 82 -D -S -G webapp webapp && \
    chmod +x app/entrypoint.sh
COPY --from=builder /opt/target/*.jar /app/demo.jar
EXPOSE 8000
USER webapp
CMD ["bash", "-c", "/app/entrypoint.sh"]