# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:11-jre-slim
VOLUME /tmp
EXPOSE 10444
ARG JAR_FILE=target/gestoria-catalogos-0.0.1.jar
COPY ${JAR_FILE} gestoria-catalogos.jar
ENTRYPOINT ["java","-jar","gestoria-catalogos.jar"]
