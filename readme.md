<<<<<<< HEAD
## URLS 
Local: http://localhost:8080/api/v1/notificacao

Swaggger: http://localhost:8080/api/swagger-ui.html

## Gerar Hash
Link: https://xorbin.com/tools/sha256-hash-calculator

Texto: evoluum-challenge

Gerado: 80ad0cafa8fe653399e00d529b772d5698f0e0b082cf278c37d0266b721c08d9

## Basic Auth
Login: ebbts

Senha: 80ad0cafa8fe653399e00d529b772d5698f0e0b082cf278c37d0266b721c08d9

```
'Authorization: Basic ZWJidHM6ZjU3NjYyYjQwZDM2MWUzODgyZTlmNGM1OTIwYjJlYWE5ODI5NGRiMmEzNDcyMGUzYjhmYTBkNDg5NTk2NGQ4Mw=='
```
## Request Body:`
```
{
    "remetente": "app-falecompresident@bbts.com.br",
    "destinatario": "rafael.salles@bbts.com.br", 
    "assunto": "TESTE EBBTS NOTIFICAÇÃO",
    "conteudo": "text/html; charset=utf-8",
    "mensagem": "<p style='color: darkgreen; font-wieigth: bolder;'>TESTE DE ENVIO DE EMAIL DO MIDDLEWARE NOTIFICAÇÃO EBBTS EM HTML.</p>",
    "sistema": "TESTE",
    "idTennant": null
}
```
## Postman code (curl)
```
curl --location --request POST 'http://localhost:8080/api/v1/notificacao' \
--header 'Authorization: Basic ZWJidHM6ZjU3NjYyYjQwZDM2MWUzODgyZTlmNGM1OTIwYjJlYWE5ODI5NGRiMmEzNDcyMGUzYjhmYTBkNDg5NTk2NGQ4Mw==' \
--header 'Content-Type: application/json' \
--data-raw '{
    "remetente": "app-falecompresident@bbts.com.br",
    "destinatario": "rafael.salles@bbts.com.br", 
    "assunto": "TESTE EBBTS NOTIFICAÇÃO",
    "conteudo": "text/html; charset=utf-8",
    "mensagem": "<p style='color: darkgreen; font-wieigth: bolder;'>TESTE DE ENVIO DE EMAIL DO MIDDLEWARE NOTIFICAÇÃO EBBTS EM HTML.</p>",
    "sistema": "TESTE",
    "idTennant": null
}'
```
=======
**Challenge for Evollum V2** 

------------------------------------
**# Day 1 (2020-05-27): Generate Base Project**
------------------------------------

**Spring Project with:**
- Language: Java
- Project: Maven
- Spring Boot Version: 2.2.7
- Java Version: 14
- Packing: jar
- Spring Boot DevTools DEVELOPER TOOLS

**with dependencys:**
- Spring Boot DevTools
- Lombok
- Spring Web
- Spring cache abstraction I/O
- Resilience4J

![enter image description here](https://i.ibb.co/897LLsf/spring-initializer.png)


------------------------------------
**# Day 2 (2020-05-28): Generate Base Project**
------------------------------------
...coming
>>>>>>> 038e34f6f4f2c6ae60e9fe24b410a58d4b7f47d5
