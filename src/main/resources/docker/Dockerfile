FROM gradle:jdk17-alpine as gradle
WORKDIR /app
COPY . .
RUN gradle bootJar



FROM openjdk:17
ENV PORT 8080
ENV SPRING_PROFILE production
COPY --from=gradle app/build/libs/*.jar app/app.jar
RUN chown -R 1000:1000 /app
USER 1000:1000
ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}", "-Dspring.profiles.active=${SPRING_PROFILE}", "app/app.jar"]



FROM jboss/keycloak:latest
ENV KEYCLOAK_USER admin
ENV KEYCLOAK_PASSWORD admin
ENV PROXY_ADDRESS_FORWARDING true
ENV PORT 8080
COPY docker-entrypoint.sh /opt/jboss/tools
ENTRYPOINT [ "/opt/jboss/tools/docker-entrypoint.sh" ]
CMD ["-b", "0.0.0.0"]
