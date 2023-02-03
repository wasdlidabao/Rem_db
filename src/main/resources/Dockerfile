# Dockerfile
FROM java:8
VOLUME /tmp
COPY songti.ttc /usr/share/fonts/song/
COPY ./Rem_db-1.0.jar  /app.jar
EXPOSE 7891
ENTRYPOINT ["java", "-jar", "-Xms256m", "-Xmx1024m", "/app.jar"]