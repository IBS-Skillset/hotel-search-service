FROM public.ecr.aws/amazoncorretto/amazoncorretto:11

WORKDIR /opt/app

COPY hotel-search-service/target/hotel-search-service.jar /opt/app/hotel-search-service.jar

ENTRYPOINT ["/usr/bin/java"]
CMD ["-Dorg.apache.catalina.STRICT_SERVLET_COMPLIANCE=true", "-jar", "/opt/app/hotel-search-service.jar"]

