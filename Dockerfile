FROM openjdk:8
ADD application-server/target/application-server-0.0.1-SNAPSHOT.jar student-management-system.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "student-management-system.jar"]