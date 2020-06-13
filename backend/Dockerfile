# build stage
FROM gradle:6.5-jdk14 as build
WORKDIR /home/gradle/birthday-playlist
COPY . .
RUN gradle build

# execution stage
FROM openjdk:14-alpine
WORKDIR /home/jdk/birthday-playlist
COPY --from=build /home/gradle/birthday-playlist/build/libs/birthdayplaylist-0.0.1-SNAPSHOT.jar /home/jdk/birthday-playlist
CMD ["java", "-jar", "birthdayplaylist-0.0.1-SNAPSHOT.jar"]