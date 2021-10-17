FROM amazoncorretto:8

RUN mkdir /opt/apps

WORKDIR /opt/apps

COPY build/libs/spring-lombok-var.jar ./

EXPOSE 8080

CMD java -jar spring-lombok-var.jar