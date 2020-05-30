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
