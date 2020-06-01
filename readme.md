
## START FROM SPRING

Command:
```
mvn spring-boot:run
```

## START FROM DOCKER

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

1. with browser (for Swagger)
Username: evoluum
Password: f57662b40d361e3882e9f4c5920b2eaa98294db2a34720e3b8fa0d4895964d83

2. with postman
```
'Authorization: Basic ZXZvbHV1bTpmNTc2NjJiNDBkMzYxZTM4ODJlOWY0YzU5MjBiMmVhYTk4Mjk0ZGIyYTM0NzIwZTNiOGZhMGQ0ODk1OTY0ZDgz'
```


## SWAGGER 

Url: http://localhost:8080/swagger-ui.html


## Postman Collections

Url: [click here](https://github.com/rafasall/challenge-evoluum/blob/master/challenge-evoluum.postman_collection.json)

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
