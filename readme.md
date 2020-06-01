## Classes Diagram
1. Client Response

![click here](https://i.ibb.co/Jyj1JZJ/response-classes.jpg)


2. MVC

![click here](https://i.ibb.co/BrPbRXn/mvc-classes.jpg)


## Patterns

1. MVC.
2. Strategy with EnumRespondeType.
3. Adapter with IDownload for CsvDownloadAdapter and JsonDownloadAdapter.

## Concetps
1. Clean code.
4. Solid.
3. TDD.

## Start from spring

Command:
```
mvn spring-boot:run
```
#
## Start from docker

Command:
1.
```
mvn package
```
2.
```
docker build --tag challenge-evoluum .
```
3.
```
docker run -p 8080:8080 challenge-evoluum
```

## Basic Auth

1. with browser for Swagger
```
Username: evoluum
```
```
Password: f57662b40d361e3882e9f4c5920b2eaa98294db2a34720e3b8fa0d4895964d83
```

2. with postman
```
'Authorization: Basic ZXZvbHV1bTpmNTc2NjJiNDBkMzYxZTM4ODJlOWY0YzU5MjBiMmVhYTk4Mjk0ZGIyYTM0NzIwZTNiOGZhMGQ0ODk1OTY0ZDgz'
```


## Swagger 

Url: http://localhost:8080/swagger-ui.html


## Postman Collections

Url: [click here](https://github.com/rafasall/challenge-evoluum/blob/master/challenge-evoluum.postman_collection.json)

## API Endpoints
- Request for all states: http://localhost:8080/api/v1/states
- Request for county by state: http://localhost:8080/api/v1/states/sp/countys
- Request for county by name: http://localhost:8080/api/v1/countys/abaetetuba
- Request for all states CSV file download: http://localhost:8080/api/v1/states/CSV
- Request for all states JSON file download: http://localhost:8080/api/v1/states/JSON
- Request for countys by state CSV file download: http://localhost:8080/api/v1/states/pa/countys/CSV
- Request for countys by state JSON file download: http://localhost:8080/api/v1/states/rj/countys/JSON

