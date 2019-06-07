FROM adoptopenjdk/openjdk11:latest
MAINTAINER Me

RUN mkdir /opt/app
COPY target/hotelreview-0.0.1-SNAPSHOT.jar /opt/app
WORKDIR /opt/app
CMD ["java", "-jar", "hotelreview-0.0.1-SNAPSHOT.jar"]