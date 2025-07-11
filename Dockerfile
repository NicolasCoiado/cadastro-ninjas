FROM eclipse-temurin:24
LABEL maintainer="nicolasmcoiado@gmail.com"
WORKDIR /CadastroDeNinjas
COPY target/CadastroDeNinjas-0.0.1-SNAPSHOT.jar /CadastroDeNinjas/cadastro-ninjas.jar
ENTRYPOINT ["java","-jar","cadastro-ninjas.jar","-web -webAllowOthers -tcp -tcpAllowOthers -browser"]
EXPOSE 8080