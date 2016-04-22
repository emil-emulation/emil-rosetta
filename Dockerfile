FROM anapsix/alpine-java:8

VOLUME /tmp

ADD target/emil-rosetta-1.1-RELEASE.jar app.jar
RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Xmx64M", "-jar","/app.jar"]
