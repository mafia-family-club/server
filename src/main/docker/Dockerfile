FROM overmind024/java
VOLUME /tmp
ENV JAVA_OPTS=""
EXPOSE 8080
ADD "target/*.jar" "app.jar"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]