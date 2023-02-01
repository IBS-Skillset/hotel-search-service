FROM amazoncorretto:11

WORKDIR /opt/app

COPY hotel-search-api/target/hotel-search-api.jar /opt/app/hotel-search-api.jar

ENTRYPOINT ["/usr/bin/java"]
CMD ["-Dspring.profiles.active=docker", "-Dorg.apache.catalina.STRICT_SERVLET_COMPLIANCE=true", "-jar", "/opt/app/hotel-search-api.jar"]

EXPOSE 8080