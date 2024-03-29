# educad-backend

## Dependências

No projeto é utilizado spring boot na versão 2.7.9 sendo codado com java utilizando dois tipos 
de banco de dados o H2 em memória caso você não tenha interesse em rodar ele com docker e o postgres 
que está integrado ao projeto para executar com o docker compose.


## Como executar o projeto

Caso você não tenha o docker instalado você deve instalar os seguintes itens: 
- [Maven](https://maven.apache.org/download.cgi)
- [Java - JDK](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
- [Intellij](https://www.jetbrains.com/idea/download/)

Na raiz do projeto executar o comando
```maven
mvn clean package -DskipTests
```
A seguir você deve executar o comando no terminal
```
java -jar -Dspring.profiles.active=test /target/backend-0.0.1-SNAPSHOT.jar
```

Caso você possua o docker instalado em sua maquina executar o comando a seguir
```docker
docker-compose up
```

É possível acessar a aplicação via localhost:8080