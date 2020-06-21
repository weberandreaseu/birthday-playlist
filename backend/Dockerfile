FROM adoptopenjdk:14-jre-hotspot as builder
WORKDIR /project
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk:14-jre-hotspot
WORKDIR /project
COPY --from=builder /project/dependencies/ ./
# https://github.com/moby/moby/issues/37965
RUN true 
COPY --from=builder /project/spring-boot-loader/ ./
RUN true
COPY --from=builder /project/snapshot-dependencies/ ./
RUN true
COPY --from=builder /project/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
