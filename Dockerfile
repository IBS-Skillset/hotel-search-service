FROM public.ecr.aws/amazoncorretto/amazoncorretto:11

WORKDIR /opt/app

COPY hotel-search-api/target/hotel-search-api.jar /opt/app/hotel-search-api.jar

ENTRYPOINT ["/usr/bin/java"]
CMD ["-Dorg.apache.catalina.STRICT_SERVLET_COMPLIANCE=true", "-jar", "/opt/app/hotel-search-api.jar"]

